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
    private UserService service;


    @PostMapping("/user")
    public void create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        if(service.findUser(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        return service.findUser(id);
    }



    @PutMapping("/user")
    public void update(@RequestBody User user)  {
        service.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        if(service.findUser(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        service.deleteUser(id);
    }

}
