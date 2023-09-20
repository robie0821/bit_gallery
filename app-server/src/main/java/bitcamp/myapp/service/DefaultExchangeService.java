package bitcamp.myapp.service;

import bitcamp.myapp.dao.ExchangeDao;
import bitcamp.myapp.vo.Exchange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultExchangeService implements ExchangeService{
  {
    System.out.println("DefaultExchangeService 생성됨!");
  }

  ExchangeDao exchangeDao;

  public DefaultExchangeService(ExchangeDao exchangeDao) {
    this.exchangeDao = exchangeDao;
  }

  @Override
  public List<Exchange> list() throws Exception {
    return exchangeDao.findAll();
  }

}
