package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuctionArticleDao {
  int insert(Article article);
  Article findBy(int articleNo);
  List<Article> findAuctionArticlesByDate(String date);
}