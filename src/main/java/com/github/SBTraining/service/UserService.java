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
         User dbUser = dao.findById(user.getId()).get();
         dbUser.setPassword(user.getPassword());
         dbUser.setLogin(user.getLogin());
         dbUser.setDateOfReg(user.getDateOfRed());
         dbUser.setEmail(user.getEmail());
         dbUser.setBalance(user.getBalance());
         dao.save(dbUser);
     }
}
