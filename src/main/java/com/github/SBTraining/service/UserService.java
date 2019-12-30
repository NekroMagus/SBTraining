package com.github.SBTraining.service;

import com.github.SBTraining.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     public User registration() {
     User user = new User();
     user.setEmail(getEmailFromPageReg());
     user.setDateOfReg(getDateOfRegFromPageReg());
     user.setLogin(getLoginFromPageReg());
     user.setPassword(getPasswordFromPageReg());
     return user;
     }
     public String getLoginFromPageReg() {
          // получаем логин , который введёт пользователь
          return new String("login");
     }
     public String getEmailFromPageReg() {
          // получаем email, который введёт пользователь
          return new String("email");
     }
     public String getPasswordFromPageReg() {
          // получаем пароль , который введёт пользователь
          return new String("password");
     }
     public String getDateOfRegFromPageReg() {
          // получаем дату регистрации , который введёт пользователь
          return new String("date");
     }
     public void changeUser(User user) {
        user.setPassword(getPasswordFromPageUpdate());
        user.setLogin(getLoginFromPageUpdate());
        user.setDateOfReg(getDateOfRegFromPageUpdate());
        user.setEmail(getEmailFromPageUpdate());
     }
     public String getLoginFromPageUpdate() {
          // получаем логин , который введёт пользователь
          return new String("login");
     }
     public String getEmailFromPageUpdate() {
          // получаем email, который введёт пользователь
          return new String("email");
     }
     public String getPasswordFromPageUpdate() {
          // получаем пароль , который введёт пользователь
          return new String("password");
     }
     public String getDateOfRegFromPageUpdate() {
          // получаем дату регистрации , который введёт пользователь
          return new String("date");
     }
}
