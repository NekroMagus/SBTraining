package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.exceptioncheckers.UserExceptionChecker;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    private final UserExceptionChecker USER_EXCEPTION_CHECKER = new UserExceptionChecker();

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao dao;

    @PostMapping("/user")
    public void create(@RequestBody User user) {
        USER_EXCEPTION_CHECKER.checkFields(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        USER_EXCEPTION_CHECKER.checkExistenceObject(dao.findById(id));
        return dao.findById(id);
    }

    @PutMapping("/user")
    public void update(@RequestBody User user)  {
        USER_EXCEPTION_CHECKER.checkFields(user);
        userService.update(user);
    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        USER_EXCEPTION_CHECKER.checkExistenceObject(dao.findById(id));
        dao.deleteById(id);
    }
}
