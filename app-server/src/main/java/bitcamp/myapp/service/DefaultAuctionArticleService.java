package bitcamp.myapp.service;

import bitcamp.myapp.dao.AuctionArticleDao;
import bitcamp.myapp.vo.AuctionArticle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultAuctionArticleService implements AuctionArticleService {

  AuctionArticleDao auctionArticleDao;

  public DefaultAuctionArticleService(AuctionArticleDao auctionArticleDao) {
    this.auctionArticleDao = auctionArticleDao;
  }

  @Transactional
  @Override
  public int add(AuctionArticle article) throws Exception {
    return auctionArticleDao.insert(article);
  }

  @Override
  public List<AuctionArticle> list(int status) throws Exception {
    return auctionArticleDao.findAll(status);
  }

  @Override
  public AuctionArticle get(int articleNo) throws Exception {
    return auctionArticleDao.findBy(articleNo);
  }

  @Transactional
  @Override
  public int update(AuctionArticle article) throws Exception {
    return auctionArticleDao.update(article);
  }

  @Transactional
  @Override
  public int delete(int articleNo) throws Exception {
    return auctionArticleDao.delete(articleNo);
  }

  @Override
  public int increaseViewCount(int articleNo) throws Exception {
    return auctionArticleDao.updateViewCount(articleNo);
  }

  @Transactional
  @Override
  public int bid(int currentPrice, int bidCount) {
    return auctionArticleDao.bid(currentPrice, bidCount);
  }
}