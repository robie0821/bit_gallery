package bitcamp.myapp.vo;

import ch.qos.logback.core.status.Status;

import java.io.Serializable;
import java.sql.Timestamp;

public class AuctionArticle implements Serializable {
  private static final long serialVersionUID = 1L;

  private int no;
  private User writer;
  private String title;
  private String content;
  private int viewCount;
  private Timestamp createdDate;
  private String photo;
  private Timestamp startDate;
  private Timestamp endDate;
  private Status status;
  private int currentPrice;
  private int endPrice;
  private int bidCount;

  @Override
  public String toString() {
    return "AuctionArticle{" +
            "no=" + no +
            ", writer=" + writer +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", viewCount=" + viewCount +
            ", createdDate=" + createdDate +
            ", photo='" + photo + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", status=" + status +
            ", currentPrice=" + currentPrice +
            ", endPrice=" + endPrice +
            ", bidCount=" + bidCount +
            '}';
  }

  public void setNo(int no) {
    this.no = no;
  }

  public void setWriter(User writer) {
    this.writer = writer;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setCurrentPrice(int currentPrice) {
    this.currentPrice = currentPrice;
  }

  public void setEndPrice(int endPrice) {
    this.endPrice = endPrice;
  }

  public void setBidCount(int bidCount) {
    this.bidCount = bidCount;
  }

  public int getNo() {
    return no;
  }

  public User getWriter() {
    return writer;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public int getViewCount() {
    return viewCount;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public String getPhoto() {
    return photo;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public Status getStatus() {
    return status;
  }

  public int getCurrentPrice() {
    return currentPrice;
  }

  public int getEndPrice() {
    return endPrice;
  }

  public int getBidCount() {
    return bidCount;
  }
}
