package bitcamp.myapp.dao;

import bitcamp.myapp.vo.AuctionArticle;
import bitcamp.myapp.vo.AuctionArticle;

import java.util.List;

public interface AuctionArticleDao {
  int insert(AuctionArticle article);
  List<AuctionArticle> findAll(String status);
  AuctionArticle findBy(int articleNo);
//  int update(Article article);
//  int delete(int articleNo);
}