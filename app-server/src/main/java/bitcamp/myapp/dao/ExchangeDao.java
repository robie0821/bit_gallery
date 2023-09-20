package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Exchange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExchangeDao {
  List<Exchange> findAll();
}
