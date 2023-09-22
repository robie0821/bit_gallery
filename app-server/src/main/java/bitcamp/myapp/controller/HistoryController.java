package bitcamp.myapp.controller;


import bitcamp.myapp.service.AnnouncementService;
import bitcamp.myapp.service.HistoryService;
import bitcamp.myapp.vo.Article;
import bitcamp.myapp.vo.History;
import bitcamp.myapp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;


    @PostMapping("bidList")
    public String bitList(
            @RequestParam("currentPage") int currentPage,
            //MultipartFile photofile, // 파일 업로드 파라미터로 지정
            HttpSession session) throws Exception {

        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/auth/form";
        }

        historyService.list(loginUser.getNo());
        return "redirect:list?status=expected&currentPage=" + currentPage;
    }


}
