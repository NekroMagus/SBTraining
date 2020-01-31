package com.github.SBTraining.restcontroller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.exceptions.ModelNotFoundException;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRestController {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao dao;


    @PostMapping("/user")
    public void create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        if(dao.findById(id)==null) {
            throw new ModelNotFoundException("объект  не найден");
        }
        return dao.findById(id);
    }



    @PutMapping("/user")
    public void update(@RequestBody User user)  {
        userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        if(dao.findById(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        dao.deleteById(id);
    }

}
