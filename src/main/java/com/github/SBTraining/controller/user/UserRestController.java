package com.github.SBTraining.controller.user;

import com.github.SBTraining.exceptions.UserNotFoundException;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRestController {
    


    @Autowired
    private UserService service;


    @PostMapping("/user")
    public void create(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        if(service.findUser(id)==null) {
            throw new UserNotFoundException("пользователь не найден");
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
            throw new UserNotFoundException("пользователь не найден");
        }
        service.deleteUser(id);
    }

}
