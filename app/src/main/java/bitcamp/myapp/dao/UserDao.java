package bitcamp.myapp.dao;

import bitcamp.myapp.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
  int insert(User user);
  User findBy(int userNo);
  User findByEmail(String email);
  List<User> findAll();
  User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
  int update(User user);
  int editUpdate(User user);
  int updatePoint(User user);
  int delete(int userNo);

  void updatePoints(@Param("userNo") String userNo, @Param("point") int point);

  void chargePoints(@Param("userNo") String userNo, @Param("point") int point);

}