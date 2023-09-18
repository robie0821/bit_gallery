package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Announcement implements Serializable {
  private static final long serialVersionUID = 1L;

  private int no;
  private String title;
  private String content;
  private User writer;
  private String password;
  private Timestamp createdDate;
  private List<AnnouncementAttachedFile> announcementAttachedFiles;

  @Override
  public String toString() {
    return "Notice{" +
            "no=" + no +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", writer=" + writer +
            ", password='" + password + '\'' +
            ", createdDate=" + createdDate +
            ", announcementAttachedFiles=" + announcementAttachedFiles +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Announcement other = (Announcement) obj;
    return no == other.no;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getWriter() {
    return writer;
  }

  public void setWriter(User writer) {
    this.writer = writer;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public List<AnnouncementAttachedFile> getAnnouncementAttachedFiles() {
    return announcementAttachedFiles;
  }

  public void setAnnouncementAttachedFiles(List<AnnouncementAttachedFile> announcementAttachedFiles) {
    this.announcementAttachedFiles = announcementAttachedFiles;
  }
}
