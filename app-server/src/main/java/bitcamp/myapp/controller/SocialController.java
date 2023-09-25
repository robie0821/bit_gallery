package bitcamp.myapp.controller;

import bitcamp.myapp.service.KakaoRequestService;
import bitcamp.myapp.vo.KakaoInfo;
import org.apache.tomcat.util.json.JSONParser;
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
        String response = kakaoRequestService.KakaoTokenRequest(kakaoInfo);
        System.out.println(response);

        System.out.println("사용자 정보 확인 시작");
        JSONParser jsonParser = new JSONParser(response);
        response = kakaoRequestService.KakaoUserInfoRequest((String)jsonParser.parseObject().get("access_token"),"https://kapi.kakao.com/v2/user/me");
        System.out.println(response);
        return "redirect:/";
    }
}
