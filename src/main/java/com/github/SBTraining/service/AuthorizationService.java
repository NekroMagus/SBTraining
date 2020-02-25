package com.github.SBTraining.service;

import com.github.SBTraining.dao.AuthorizedUser;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizedUser dao;

    public boolean checkUser(User user) {
        boolean flag = false;
        List<User> list = dao.findAll();
        for (User u : list) {
            if (u.equals(user)) {
                flag = true;
            }
        }
            return flag;
    }

    public void saveUser(User user) {
        dao.save(user);
    }

}
