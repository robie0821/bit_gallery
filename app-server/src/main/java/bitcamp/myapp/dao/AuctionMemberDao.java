package bitcamp.myapp.dao;

import bitcamp.myapp.vo.AuctionMember;

public interface AuctionMemberDao {
  int insert(AuctionMember user);
  AuctionMember findBy(int userNo);
  int update(AuctionMember user);
  int updatePoint(AuctionMember user);
  int delete(int userNo);
}