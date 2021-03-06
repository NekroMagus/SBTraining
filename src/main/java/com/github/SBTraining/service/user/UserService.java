package com.github.SBTraining.service.user;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return dao.findAll();
    }

    public void deleteAllUsers() {
        dao.deleteAll();
    }

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

