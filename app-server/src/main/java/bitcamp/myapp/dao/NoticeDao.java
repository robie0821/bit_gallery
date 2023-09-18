package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Notice;
import bitcamp.myapp.vo.NoticeAttachedFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {
  int insert(Notice notice);
  List<Notice> findAll();
  Notice findBy(int no);
  int update(Notice notice);
  int delete(int no);

  int insertFiles(Notice notice);
  NoticeAttachedFile findFileBy(int no);
  int deleteFile(int fileNo);
  int deleteFiles(int noticeNo);
}
