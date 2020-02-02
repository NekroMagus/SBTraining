package com.github.SBTraining.service;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      @Autowired
     private UserDao dao;

     public void update(User user) {
         User dbUser = dao.findById(user.getId());
         dbUser.setPassword(user.getPassword());
         dbUser.setLogin(user.getLogin());
         dbUser.setRegDate(user.getRegDate());
         dbUser.setEmail(user.getEmail());
         dbUser.setBalance(user.getBalance());
         dao.save(dbUser);
     }

     public void createUser(User user) {
         dao.save(user);
     }

     public void deleteUser(long id) {
         dao.deleteById(id);
     }

     public User findUser(long id) {
         return dao.findById(id);
     }

}
