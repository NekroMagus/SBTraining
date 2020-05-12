package com.github.SBTraining.controller.user;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.exceptions.UserNotFoundException;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class UserRestController {

    //TODO: delete unused variable
    @Autowired
    private UserDao dao;

    @Autowired
    private UserService service;

    //TODO: delete unused variable
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public void create(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        if (service.findUser(id) == null) {
            throw new UserNotFoundException("пользователь не найден");
        }
        return service.findUser(id);
    }

    //TODO: it's GetMapping not Post. Why you didn't return any values???
    @GetMapping("/add1")
    public void add1() {
        User user = new User();
        user.setLogin("Mark");
        user.setPassword("1111");
        service.createUser(user);
    }

    @GetMapping("/add2")
    public User add2() {
        return service.findUserByLogin("Mark");
    }

    @GetMapping("/checkA")
    public String check() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }



    @PutMapping("/user")
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        if (service.findUser(id) == null) {
            throw new UserNotFoundException("пользователь не найден");
        }
        service.deleteUser(id);
    }

    @GetMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {
        return service.findUserByLogin(principal.getName());
    }
}
