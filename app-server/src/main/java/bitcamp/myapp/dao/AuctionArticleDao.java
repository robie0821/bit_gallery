package bitcamp.myapp.dao;

import bitcamp.myapp.vo.AuctionArticle;
import bitcamp.myapp.vo.AuctionArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuctionArticleDao {
  int insert(AuctionArticle article);

  List<AuctionArticle> findAll(int status);

  AuctionArticle findBy(int articleNo);

  int update(AuctionArticle article);

  int delete(int articleNo);

  int updateViewCount(int articleNo);

  int bid(@Param("current_price") int currentPrice, @Param("bid_count") int bidCount);
}