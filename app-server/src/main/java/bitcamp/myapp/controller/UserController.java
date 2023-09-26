package bitcamp.myapp.controller;

import bitcamp.myapp.service.NcpObjectStorageService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
  {
  }


  @Autowired
  UserService userService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @GetMapping("form")
  public void form() {
  }

  @GetMapping("edit")
  public String showEditPage(HttpSession session, Model model) {
    User loginUser = (User) session.getAttribute("loginUser");
    String email = (String) session.getAttribute("email");

    // 모델에 이메일 값을 추가합니다.
    model.addAttribute("email", email);
    if (loginUser == null) {
      return "redirect:/login";
    } else {
      model.addAttribute("user", loginUser); // "user"라는 이름으로 사용자 객체 추가
      return "user/edit";
    }
  }

  @PostMapping("add")
  public String add(User user) throws Exception {
    System.out.println(user.toString());
    userService.add(user);
    return "redirect:/";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    if (userService.delete(no) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    } else {
      return "redirect:list";
    }
  }

  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) throws Exception {
    model.addAttribute("user", userService.get(no));
    return "user/detail";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", userService.list());
  }

  @PostMapping("update")
  public String update(User user, MultipartFile photofile) throws Exception {
//    if (photofile.getSize() > 0) {
//      String uploadFileUrl = ncpObjectStorageService.uploadFile(
//              "bitcamp-nc7-bucket-118", "user/", photofile);
//      member.setPhoto(uploadFileUrl);
//    }

    if (userService.update(user) == 0) {
      throw new Exception("회원이 없습니다.");
    } else {
      return "redirect:list";
    }
  }

  @PostMapping("editUpdate")
  public String editUpdate(@ModelAttribute("user") User updatedUser, HttpSession session) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");

    if (loginUser == null) {
      return "redirect:/login";
    }

    // 현재 로그인한 사용자의 정보로 업데이트할 정보 설정
    updatedUser.setNo(loginUser.getNo());
    updatedUser.setEmail(loginUser.getEmail());

    // 세션 정보 업데이트
    session.setAttribute("loginUser", updatedUser); // 세션 업데이트

    // 사용자 정보 업데이트
    if (userService.editUpdate(updatedUser) == 0) {
      throw new Exception("회원 정보 업데이트에 실패했습니다.");
    } else {
      return "redirect:/points/chargePoint";
    }
  }
}