package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class AuctionMember implements Serializable {
  private static final long serialVersionUID = 1L;


  private int no;
  private boolean authority;
  private String email;
  private String password;
  private String name;
  private String phone;

  public void setNo(int no) {
    this.no = no;
  }

  public void setAuthority(boolean authority) {
    this.authority = authority;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setZonecode(int zonecode) {
    this.zonecode = zonecode;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  public void setProfile_photo(String profile_photo) {
    this.profile_photo = profile_photo;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  public int getNo() {
    return no;
  }

  public boolean isAuthority() {
    return authority;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public int getZonecode() {
    return zonecode;
  }

  public String getAddress() {
    return address;
  }

  public Date getJoinDate() {
    return joinDate;
  }

  public String getProfile_photo() {
    return profile_photo;
  }

  public Integer getPoint() {
    return point;
  }

  private int zonecode; // 카카오 우편번호
  private String address;
  private Date joinDate;
  private String profile_photo;
  private Integer point;

  @Override
  public String toString() {
    return "ActionMember{" +
            "no=" + no +
            ", authority=" + authority +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", zonecode=" + zonecode +
            ", address='" + address + '\'' +
            ", joinDate=" + joinDate +
            ", profile_photo='" + profile_photo + '\'' +
            ", point=" + point +
            '}';
  }
}

