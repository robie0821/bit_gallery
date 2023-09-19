package bitcamp.myapp.controller;

import bitcamp.myapp.service.AuctionArticleService;
import bitcamp.myapp.service.NcpObjectStorageService;
import bitcamp.myapp.vo.AuctionArticle;
import bitcamp.myapp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/article")
public class AuctionArticleController {
}

  @Autowired
  AuctionArticleService auctionArticleService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @GetMapping("form")
  public void form() {

  }

  @PostMapping("add")
  public String add(
          AuctionArticle auctionArticle,
          MultipartFile photofile,
          HttpSession session) throws Exception {

//    User loginUser = (User) session.getAttribute("loginUser");
//    if (loginUser == null) {
//      return "redirect:/auth/form";
//    }

    auctionArticle.setWriter(new User());

    if (photofile.getSize() > 0) {
      String uploadFileUrl = ncpObjectStorageService.uploadFile(
              "bitgallery", "article/", photofile);
      auctionArticle.setPhoto(uploadFileUrl);
    }
    auctionArticleService.add(auctionArticle);
    return "redirect:list";
  }
  @GetMapping("delete")
  public String delete(int articleNo) throws Exception {
    AuctionArticle auctionArticle = auctionArticleService.get(articleNo);
    if (auctionArticle == null) {
      throw new Exception("해당 번호의 게시글이 없습니다");
    }
    else if (auctionArticle.getStatus() != 0) {
      throw new Exception("시작되지 않은 경매만 삭제가 가능합니다.");
    } else if (auctionArticleService.delete(auctionArticle.getArticleNo()) == 0) {
      throw new Exception("삭제 오류");
    } else {
      return "redirect:list";
    }
  }

  @GetMapping("detail/{no}")
  public String detail(int articleNo, Model model) throws Exception {
    AuctionArticle auctionArticle = auctionArticleService.get(articleNo);
    if (auctionArticle != null) {
      auctionArticleService.increaseViewCount(articleNo);
      model.addAttribute("auctionArticle", auctionArticle);
    }
    return "board/detail";
  }

  @GetMapping("list")
  public void list(int status, Model model) throws Exception {
    model.addAttribute("list", auctionArticleService.list(status));
  }
}