package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: need annotation
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao dao;

    //TODO: mapping could be /user
    @PostMapping("/create")
    public void create() {
        dao.save(userService.registration());
    }

    //TODO: mapping could be /user and need add /{id} like in class TeapotRestController
    @GetMapping("/find")
    public User find(@PathVariable("id") long id) {
        return dao.findById(id).get();
    }

    //TODO: mapping could be /user
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.changeUser(user);
        dao.save(user);
    }

    //TODO: mapping could be /user
    @DeleteMapping("/delete")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }
}
