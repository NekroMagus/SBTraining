package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao dao;

    @PostMapping("/user")
    public void create(@RequestBody User user) {
        dao.save(user);
    }
    @GetMapping("/add")
    public void add() {
        User user = new User();
        user.setBalance(123);
        user.setEmail("q4y ");
        user.setDateOfReg("123");
        user.setLogin("egor");
        user.setPassword("12345");
        dao.save(user);
    }
    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        return dao.findById(id).get();
    }

    @PutMapping("/user")
    public void update(@RequestBody User user) {
        userService.update(user);
    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }
}
