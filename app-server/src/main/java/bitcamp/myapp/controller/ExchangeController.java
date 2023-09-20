package bitcamp.myapp.controller;

import bitcamp.myapp.service.ExchangeService;
import bitcamp.myapp.service.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", exchangeService.list());
  }

}

