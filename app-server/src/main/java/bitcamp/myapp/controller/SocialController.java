package bitcamp.myapp.controller;

import bitcamp.myapp.service.KakaoRequestService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.KakaoInfo;
import bitcamp.myapp.vo.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@Controller
@RequestMapping("/social")
public class SocialController {

    {
        System.out.println("KakaoController 생성됨!");
    }


    KakaoRequestService kakaoRequestService= new KakaoRequestService();

    @Autowired
    UserService userService;

    @GetMapping("kakao")
    public String kakao(KakaoInfo kakaoInfo, HttpSession session, Model model, HttpServletResponse res) throws Exception {

        //System.out.println("kakaoInfo : " + kakaoInfo.toString());


        //System.out.println("토큰 확인 시작");
        String response = kakaoRequestService.KakaoTokenRequest(kakaoInfo);
        //System.out.println(response);

        //System.out.println("사용자 정보 확인 시작");
        JSONParser jsonParser = new JSONParser(response);
        response = kakaoRequestService.KakaoUserInfoRequest((String)jsonParser.parseObject().get("access_token"),"https://kapi.kakao.com/v2/user/me");
        //System.out.println(response);

        ObjectMapper objectMapper = new ObjectMapper();
        // JSON 문자열을 JsonNode로 파싱
        JsonNode jsonNode = objectMapper.readTree(response);

        // 필드에 접근
        JsonNode infoNode = jsonNode.get("kakao_account");
        String email = infoNode.get("email").asText();


        //로그인 처리
        User loginUser = userService.get(email);
        if (loginUser == null) {
            //유저 생성코드 추가
            System.out.println(email);
            User user = new User();
            user.setEmail(email);
            user.setPassword("1111");
            user.setPhone("000-0000-0000");
            user.setAddress("기본주소");
            user.setDetailAddr("상세주소");
            user.setName("소셜유저");
            user.setZonecode(0);
            userService.add(user);
            loginUser = user;

        }

        session.setAttribute("loginUser", loginUser);
        return "redirect:/";
    }
}
