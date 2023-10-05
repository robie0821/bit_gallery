package bitcamp.myapp.service;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultUserService implements UserService {
  {
  }

  UserDao userDao;

  public DefaultUserService(UserDao userDao) {
    this.userDao = userDao;
  }

  @Transactional
  @Override
  public int add(User user) throws Exception {
    return userDao.insert(user);
  }

  @Override
  public List<User> list() throws Exception {
    return userDao.findAll();
  }

  @Override
  public User get(int userNo) throws Exception {
    return userDao.findBy(userNo);
  }

  @Override
  public User get(String email, String password) throws Exception {
    return userDao.findByEmailAndPassword(email, password);
  }

  @Override
  public User get(String email) throws Exception {
    return userDao.findByEmail(email);
  }

  @Transactional
  @Override
  public int update(User user) throws Exception {
    return userDao.update(user);
  }

  @Transactional
  @Override
  public int editUpdate(User user) throws Exception {
    return userDao.editUpdate(user);
  }

  @Transactional
  @Override
  public int delete(int userNo) throws Exception {
    return userDao.delete(userNo);
  }

  @Override
  public void updateUserPoints(String userNo, int point) {
    userDao.updatePoints(userNo, point);
  }

  @Override
  public void chargeUserPoints(String userNo, int point) {
    userDao.chargePoints(userNo, point);
  }
}
