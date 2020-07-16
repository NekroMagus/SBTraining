package com.github.SBTraining.controller.user;

import com.github.SBTraining.exceptions.UserNotFoundException;
import com.github.SBTraining.model.Role;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtTokenFilter;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
public class UserRestController {

    static Logger log = Logger.getLogger(UserRestController.class.getName());

    @Autowired
    private  JwtTokenFilter jwtTokenFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public String create(@RequestBody User user) {
        service.createUser(user);
        log.info("user created,user:" + user.toString());
        return "user created";
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        if (service.findUser(id) == null) {
            throw new UserNotFoundException("пользователь не найден");
        }
        return service.findUser(id);
    }

    @PutMapping("/user")
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") long id) {
        if (service.findUser(id) == null) {
            throw new UserNotFoundException("пользователь не найден");
        }
        service.deleteUser(id);
        log.info("user deleted,user:" + service.findUser(id).toString());
        return "user deleted";
    }

    @GetMapping("/getCurrentUser")
    public User getCurrentUser() {
        User result = null;
        if(jwtTokenFilter.getSecurityContext().getAuthentication()!=null)
            result=service.findUserByLogin(jwtTokenFilter.getSecurityContext().getAuthentication().getName());
        return result;
    }

    @PostMapping("/add1")
    public void add1() {
        User user = new User();
        user.setLogin("Alee");
        user.setPassword(passwordEncoder.encode("1111"));
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        user.setRole(role);
        service.createUser(user);
    }

}
