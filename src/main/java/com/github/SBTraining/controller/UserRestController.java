package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao dao;

    @PostMapping("/create")
    public void create() {
        dao.save(userService.registration());
    }

    @GetMapping("/find")
    public User find(@PathVariable("id") long id) {
        return dao.findById(id).get();
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.changeUser(user);
        dao.save(user);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }
}
