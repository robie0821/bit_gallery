package bitcamp.myapp.service;

import bitcamp.myapp.vo.AuctionArticle;
import bitcamp.myapp.vo.Status;

import java.util.List;

public interface AuctionArticleService {
    int add(AuctionArticle auctionArticle) throws Exception;
    List<AuctionArticle> list(Status status) throws Exception;
    AuctionArticle get(int articleNo) throws Exception;
    int update(AuctionArticle auctionArticle) throws Exception;
    int delete(int articleNo) throws Exception;

    int bid(int currentPrice);
}
