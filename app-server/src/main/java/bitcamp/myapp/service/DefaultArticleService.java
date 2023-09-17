package bitcamp.myapp.service;

import bitcamp.myapp.dao.AuctionArticleDao;
import bitcamp.myapp.vo.AuctionArticle;
import bitcamp.myapp.vo.Status;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DefaultArticleService implements ArticleService {

    AuctionArticleDao auctionArticleDao;

    public DefaultArticleService(AuctionArticleDao auctionArticleDao) {
        this.auctionArticleDao = auctionArticleDao;
    }

    @Transactional
    @Override
    public int add(AuctionArticle article) throws Exception {
        return auctionArticleDao.insert(article);
    }

    @Override
    public List<AuctionArticle> list(Status status) throws Exception {
        return auctionArticleDao.findAll(status.toString());
    }

    @Override
    public AuctionArticle get(int articleNo) throws Exception {
        return auctionArticleDao.findBy(articleNo);
    }

    //    @Transactional
//    @Override
//    public int update(AuctionArticle article) throws Exception {
//        return 0;
//    }
//
//    @Transactional
//    @Override
//    public int delete(int articleNo) throws Exception {
//        return 0;
//    }

    @Transactional
    @Override
    public int bid(int currentPrice, int bidCount) {
        return auctionArticleDao.bid(currentPrice, bidCount);
    }
}
