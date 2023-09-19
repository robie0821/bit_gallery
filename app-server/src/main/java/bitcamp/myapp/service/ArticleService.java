package bitcamp.myapp.service;

import bitcamp.myapp.vo.Article;

import java.util.List;

public interface ArticleService {
  int add(Article article) throws Exception;

  List<Article> list(int status) throws Exception;

  Article get(int articleNo) throws Exception;

  int update(Article article) throws Exception;

  int delete(int articleNo) throws Exception;


  int increaseViewCount(int articleNo) throws Exception;

  int bid(int currentPrice, int bidCount);
}