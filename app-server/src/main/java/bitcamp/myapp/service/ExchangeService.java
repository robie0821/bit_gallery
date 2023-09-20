package bitcamp.myapp.service;

import bitcamp.myapp.vo.Exchange;

import java.util.List;

public interface ExchangeService {
  List<Exchange> list() throws Exception;
}
