package bitcamp.myapp.dao;

import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.AuctionNotice;

import java.util.List;

public interface AuctionNoticeDao {
  int insert(AuctionNotice notice);
  List<AuctionNotice> findAll();
  AuctionNotice findBy(int noticeNo);
  int update(AuctionNotice notice);
  int updateCount(int noticeNo);
  int delete(int noticeNo);

  int insertFiles(AuctionNotice notice);
  AttachedFile findFileBy(int fileNo);
  int deleteFile(int fileNo);
  int deleteFiles(int noticeNo);
}