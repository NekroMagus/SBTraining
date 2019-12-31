package com.github.SBTraining.service;

import com.github.SBTraining.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

     //TODO: need change like TeapotService
     public User registration() {
     User user = new User();
     user.setEmail(getEmailFromPage());
     user.setDateOfReg(getDateOfRegFromPage());
     user.setLogin(getLoginFromPage());
     user.setPassword(getPasswordFromPage());
     return user;
     }
     public String getLoginFromPage() {
          // получаем логин , который введёт пользователь
          return new String("login");
     }
     public String getEmailFromPage() {
          // получаем email, который введёт пользователь
          return new String("email");
     }
     public String getPasswordFromPage() {
          // получаем пароль , который введёт пользователь
          return new String("password");
     }
     public String getDateOfRegFromPage() {
          // получаем дату регистрации , который введёт пользователь
          return new String("date");
     }
     public void changeUser(User user) {
          user.setPassword(getPasswordFromPage());
          user.setLogin(getLoginFromPage());
          user.setDateOfReg(getDateOfRegFromPage());
          user.setEmail(getEmailFromPage());
     }
}
