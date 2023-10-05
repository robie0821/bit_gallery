package bitcamp.myapp.service;

import bitcamp.myapp.dao.ArticleDao;
import bitcamp.myapp.vo.Article;
import bitcamp.myapp.vo.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DefaultArticleService implements ArticleService {

  ArticleDao articleDao;

  public DefaultArticleService(ArticleDao articleDao) {
    this.articleDao = articleDao;
  }

  @Transactional
  @Override
  public int add(Article article) throws Exception {

    if (article.getTitle().isEmpty()) {
      return 2;
    } else if (article.getArtist().isEmpty()) {
      return 3;
    } else if (article.getPhoto() == null) {
      return 4;
    }
    return articleDao.insert(article);
  }

  @Override
  public void list(Status status, Model model) throws Exception {
    try {
      int currentPage = 0;
      if (model.getAttribute("currentPage") == null) {
        currentPage = 1;
      } else {
        currentPage = (Integer) model.getAttribute("currentPage");
      }
      List<Article> list = articleDao.findAll(status);
      int size = list.size();
      int pageSize = 4;
      int startPage = (currentPage - 1) * pageSize ;
      int endPage = Math.min(pageSize, size - startPage);
      List<Article> subList = list.stream().skip(startPage).limit(endPage).toList();

      model.addAttribute("pageSize", pageSize);
      model.addAttribute("size", size);
      model.addAttribute("list", subList);
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("actualSize", Math.ceil((double)size / (double)pageSize));
      model.addAttribute("status", status.name());
      model.addAttribute("path", 0);
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public void search(String artist, Model model) throws Exception {
    try {
      int currentPage = 0;
      if (model.getAttribute("currentPage") == null) {
        currentPage = 1;
      } else {
        currentPage = (Integer) model.getAttribute("currentPage");
      }
      List<Article> list = articleDao.findByArtist(artist);
      int size = list.size();
      int pageSize = 4;
      int startPage = (currentPage - 1) * pageSize ;
      int endPage = Math.min(pageSize, size - startPage);
      List<Article> subList = list.stream().skip(startPage).limit(endPage).toList();

      model.addAttribute("pageSize", size);
      model.addAttribute("list", subList);
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("actualSize", Math.ceil((double)size / (double)pageSize));
      model.addAttribute("artist", artist);
      model.addAttribute("path", 1);
    } catch (Exception e) {
      throw e;
    }
  }

  public List<Article> findAuctionArticlesByDate(String date) throws Exception {
    return articleDao.findAuctionArticlesByDate(date);
  }

  @Override
  public Article get(int articleNo) throws Exception {
    return articleDao.findBy(articleNo);
  }

  @Transactional
  @Override
  public int update(Article article) throws Exception {
    return articleDao.update(article);
  }

  @Transactional
  @Override
  public int delete(int articleNo) throws Exception {
    return articleDao.delete(articleNo);
  }

  @Override
  public int increaseViewCount(int articleNo) throws Exception {
    return articleDao.updateViewCount(articleNo);
  }

  @Transactional
  @Override
  public int bid(Article article) {
    return articleDao.bid(article);
  }

  @Transactional
  @Override
  public int buy(Article article) {
    return articleDao.buy(article);
  }

  @Override
  public int updateArticleBidNum(int articleNo) throws Exception {
    return articleDao.updateArticleBidNum(articleNo);
  }

  @Override
  public void updateArticleBidPoint(int articleNo, int bidAmount, int userNo) {
    articleDao.updateArticleBidPoint(articleNo,bidAmount, userNo);
  }

  @Override
  public void returnPoint(int articleNo) {
    articleDao.returnPoint(articleNo);
  }

  @Override
  public void updateArticleStatus(int articleNo) throws Exception {
    articleDao.updateArticleStatus(articleNo);
  }
}