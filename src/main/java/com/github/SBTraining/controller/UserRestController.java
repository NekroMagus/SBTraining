package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao dao;
    @GetMapping("/create")
    public void create() {
       dao.save(userService.registration());
    }
    public User find(@PathVariable("id") long id) {
        return dao.findById(id).get();
    }
    @GetMapping("/update")
    public void update(@PathVariable("id") long id) {
        User user = dao.findById(id).get();
        userService.changeUser(user);
        dao.save(user);
    }
    @GetMapping("/delete")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }
}