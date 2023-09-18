package bitcamp.myapp.service;

import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import bitcamp.myapp.vo.NoticeAttachedFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultNoticeService implements NoticeService {

  NoticeDao noticeDao;

  public DefaultNoticeService(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Transactional // 이 메서드는 트랜잭션 상태에서 실행하라고 지정
  @Override
  public int add(Notice notice) throws Exception {
    int count = noticeDao.insert(notice);
    if (notice.getNoticeAttachedFiles().size() > 0) {
      noticeDao.insertFiles(notice);
    }
    return count;
  }

  @Override
  public List<Notice> list() throws Exception {
    return noticeDao.findAll();
  }

  @Override
  public Notice get(int noticeNo) throws Exception {
    return noticeDao.findBy(noticeNo);
  }

  @Transactional
  @Override
  public int update(Notice notice) throws Exception {
    int count = noticeDao.update(notice);
    if (count > 0 && notice.getNoticeAttachedFiles().size() > 0) {
      noticeDao.insertFiles(notice);
    }
    return count;
  }

  @Transactional
  @Override
  public int delete(int noticeNo) throws Exception {
    noticeDao.deleteFiles(noticeNo);
    return noticeDao.delete(noticeNo);
  }

  @Override
  public NoticeAttachedFile getNoticeAttachedFile(int fileNo) throws Exception {
    return noticeDao.findFileBy(fileNo);
  }

  @Override
  public int deleteAttachedFile(int fileNo) throws Exception {
    return noticeDao.deleteFile(fileNo);
  }
}
