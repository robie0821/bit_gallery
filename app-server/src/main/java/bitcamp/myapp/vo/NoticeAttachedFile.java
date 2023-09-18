package bitcamp.myapp.vo;

import java.io.Serializable;

public class NoticeAttachedFile implements Serializable {
  private static final long serialVersionUID = 1L;

  int no;
  String originName;
  String filePath;
  int noticeNo;

  @Override
  public String toString() {
    return "NoticeAttachedFile{" +
            "no=" + no +
            ", originName='" + originName + '\'' +
            ", filePath='" + filePath + '\'' +
            ", noticeNo=" + noticeNo +
            '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getOriginName() {
    return originName;
  }

  public void setOriginName(String originName) {
    this.originName = originName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public int getNoticeNo() {
    return noticeNo;
  }

  public void setNoticeNo(int noticeNo) {
    this.noticeNo = noticeNo;
  }
}
