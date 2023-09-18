package bitcamp.myapp.controller;

import bitcamp.myapp.service.NcpObjectStorageService;
import bitcamp.myapp.service.NoticeService;
import bitcamp.myapp.vo.Member;
import bitcamp.myapp.vo.Notice;
import bitcamp.myapp.vo.NoticeAttachedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/notice")
public class NoticeController {

  @Autowired
  NoticeService noticeService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @GetMapping("form")
  public void form() {
  }

  @PostMapping("add")
  public String add(Notice notice, MultipartFile[] files, HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:/auth/form";
    }

    notice.setWriter(loginUser);

    ArrayList<NoticeAttachedFile> noticeAttachedFiles = new ArrayList<>();
    for (MultipartFile part : files) {
      if (part.getSize() > 0) {
        String uploadFileUrl = ncpObjectStorageService.uploadFile(
                "bitgallery", "notice/", part);
        NoticeAttachedFile noticeAttachedFile = new NoticeAttachedFile();
        noticeAttachedFile.setFilePath(uploadFileUrl);
        noticeAttachedFiles.add(noticeAttachedFile);
      }
    }
    notice.setNoticeAttachedFiles(noticeAttachedFiles);

    noticeService.add(notice);
    return "redirect:/notice/list";
  }

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:/auth/form";
    }

    Notice n = noticeService.get(no);

    if (n == null || n.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
    } else {
      noticeService.delete(n.getNo());
      return "redirect:/notice/list";
    }
  }

  @GetMapping("detail/{no}")
  public String detail(@PathVariable int no, Model model) throws Exception {
    Notice notice = noticeService.get(no);
    if (notice != null) {
      model.addAttribute("notice", notice);
    }
    return "notice/detail";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list");
  }

  @PostMapping("update")
  public String update(Notice notice, MultipartFile[] files, HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:/auth/form";
    }

    Notice n = noticeService.get(notice.getNo());
    if (n == null || n.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("게시글이 존재하지 않거나 변경 권한이 없습니다.");
    }

    ArrayList<NoticeAttachedFile> noticeAttachedFiles = new ArrayList<>();
    for (MultipartFile part : files) {
      if (part.getSize() > 0) {
        String uploadFileUrl = ncpObjectStorageService.uploadFile(
                "bitgallery", "notice/", part);
        NoticeAttachedFile noticeAttachedFile = new NoticeAttachedFile();
        noticeAttachedFile.setFilePath(uploadFileUrl);
        noticeAttachedFiles.add(noticeAttachedFile);
      }
    }
    notice.setNoticeAttachedFiles(noticeAttachedFiles);

    noticeService.update(notice);
    return "redirect:/notice/list";
  }

  @GetMapping("fileDelete/{noticeAttachedFile}")
  public String fileDelete(@MatrixVariable("no") int no, HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:/auth/form";
    }

    Notice notice = null;
    NoticeAttachedFile noticeAttachedFile = noticeService.getNoticeAttachedFile(no);
    notice = noticeService.get(noticeAttachedFile.getNoticeNo());
    if (notice.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("게시글 변경 권한이 없습니다!");
    }

    if (noticeService.deleteAttachedFile(no) == 0) {
      throw new Exception("해당 번호의 첨부파일이 없습니다.");
    } else {
      return "redirect:/notice/detail/" + notice.getNo();
    }
  }
}











