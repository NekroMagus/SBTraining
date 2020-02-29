package com.github.SBTraining.service;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void update(User user) {
        User dbUser = dao.findById(user.getId());
        dbUser.setPassword(passwordEncoder.encode(user.getPassword()));
        dbUser.setLogin(user.getLogin());
        dbUser.setRegDate(user.getRegDate());
        dbUser.setEmail(user.getEmail());
        dbUser.setBalance(user.getBalance());
        dao.save(dbUser);
    }

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    public void deleteUser(long id) {
        dao.deleteById(id);
    }

    public User findUser(long id) {
        return dao.findById(id);
    }

    public User findUserByLogin(String login) {
        return dao.findByLogin(login);
    }

}

