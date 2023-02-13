package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Component
public class UserServiceImp implements UserService {


   private UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao dao) {
      this.userDao = dao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional
   public User getUser(String model, int series) {
      return userDao.getUser(model, series);
   }

  public User getUserById(int id) {
      return userDao.getUserById(id);
  }

}
