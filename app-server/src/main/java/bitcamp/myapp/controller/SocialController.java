package bitcamp.myapp.controller;

import bitcamp.myapp.service.KakaoRequestService;
import bitcamp.myapp.vo.KakaoInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;




@RestController
@RequestMapping("/social")
public class SocialController {

    {
        System.out.println("KakaoController 생성됨!");
    }


    KakaoRequestService kakaoRequestService= new KakaoRequestService();

    @GetMapping("kakao")
    public String kakao(KakaoInfo kakaoInfo, HttpSession session) throws Exception {
        System.out.println("kakaoInfo : " + kakaoInfo.toString());


        System.out.println("토큰 확인 시작");
        String response = kakaoRequestService.sendPostRequest(kakaoInfo);
        System.out.println(response);
        return "redirect:/";
    }
}
