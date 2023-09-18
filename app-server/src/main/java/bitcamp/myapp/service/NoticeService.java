package bitcamp.myapp.service;

import bitcamp.myapp.vo.Notice;
import bitcamp.myapp.vo.NoticeAttachedFile;

import java.util.List;

public interface NoticeService {
  int add(Notice notice) throws Exception;
  List<Notice> list() throws Exception;
  Notice get(int noticeNo) throws Exception;
  int update(Notice notice) throws Exception;
  int delete(int noticeNo) throws Exception;

  NoticeAttachedFile getNoticeAttachedFile(int fileNo) throws Exception;
  int deleteAttachedFile(int fileNo) throws Exception;
}
