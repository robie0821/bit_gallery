package bitcamp.myapp.controller;

import bitcamp.myapp.service.ExchangeService;
import bitcamp.myapp.service.NcpObjectStorageService;
import bitcamp.myapp.vo.Exchange;
import bitcamp.myapp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

  {
    System.out.println("ExchangeController 생성됨!");
  }

  @Autowired
  ExchangeService exchangeService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @GetMapping("form")
  public void form() {
  }

  @PostMapping("add")
  public String add(Exchange exchange, HttpSession session) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:/auth/form";
    }

    exchange.setUser(loginUser);
    exchange.setTitle(loginUser.getName() + "님 환전요청");
    exchange.setCreatedDate(new Date());

    exchangeService.add(exchange);
    return "redirect:/exchange/list";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", exchangeService.list());
  }

  @GetMapping("detail/{no}")
  public String detail(@PathVariable int no, Model model) throws Exception {
    Exchange exchange = exchangeService.get(no);
    if (exchange != null) {
      model.addAttribute("exchange", exchange);
    }
    return "exchange/detail";
  }


//  @GetMapping("detail/{no}")
//  public String detail(@PathVariable int no, Model model) throws Exception {
//    Exchange exchange = exchangeService.get(no);
//    if (exchange != null) {
//      exchangeService.increaseViewCount(no);
//      model.addAttribute("exchane", exchange);
//    }
//    return "board/detail";
//  }



}

