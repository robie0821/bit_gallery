package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class AuctionArticle implements Serializable {
  private static final long serialVersionUID = 1L;

  private int articleNo;
  private User writer;
  private String title;
  private String content;
  private String artist;
  private int viewCount;
  private Date createdDate;
  private String photo;
  private Date startDate;
  private Date endDate;
  private int status;
  private int curPrice;
  private int endPrice;
  private int bidCount;

  @Override
  public String toString() {
    return "AuctionArticle{" +
            "no=" + articleNo +
            ", writer=" + writer +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", viewCount=" + viewCount +
            ", createdDate=" + createdDate +
            ", photo='" + photo + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", status=" + status +
            ", currentPrice=" + curPrice +
            ", endPrice=" + endPrice +
            ", bidCount=" + bidCount +
            '}';
  }

  public int getArticleNo() {
    return articleNo;
  }

  public void setArticleNo(int articleNo) {
    this.articleNo = articleNo;
  }

  public User getWriter() {
    return writer;
  }

  public void setWriter(User writer) {
    this.writer = writer;
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

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getCurPrice() {
    return curPrice;
  }

  public void setCurPrice(int curPrice) {
    this.curPrice = curPrice;
  }

  public int getEndPrice() {
    return endPrice;
  }

  public void setEndPrice(int endPrice) {
    this.endPrice = endPrice;
  }

  public int getBidCount() {
    return bidCount;
  }

  public void setBidCount(int bidCount) {
    this.bidCount = bidCount;
  }
}