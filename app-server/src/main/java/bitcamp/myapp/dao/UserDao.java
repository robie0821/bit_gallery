package bitcamp.myapp.dao;

import bitcamp.myapp.vo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
  int insert(User user);
  User findBy(int userNo);
  User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
  int update(User user);
  int updatePoint(User user);
  int delete(int userNo);
}