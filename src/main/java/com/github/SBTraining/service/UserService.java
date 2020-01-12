package com.github.SBTraining.service;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     @Autowired
     private UserDao dao;

     public void update(User user) {
         if(user.getDateOfRed()==null || user.getEmail()==null || user.getLogin()==null || user.getPassword()==null)new FieldNullException("одно из полей пустое");
         User dbUser = dao.findById(user.getId());
         dbUser.setPassword(user.getPassword());
         dbUser.setLogin(user.getLogin());
         dbUser.setDateOfReg(user.getDateOfRed());
         dbUser.setEmail(user.getEmail());
         dbUser.setBalance(user.getBalance());
         dao.save(dbUser);
     }
}
