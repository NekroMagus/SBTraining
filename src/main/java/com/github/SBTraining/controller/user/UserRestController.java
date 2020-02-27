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

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.security.Principal;
import java.util.List;


@RestController
public class UserRestController {
    
    @Autowired
    private UserDao dao;

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @GetMapping("/add1")
    public void add1() {
        User user = new User();
        user.setLogin("Mark");
        user.setPassword("1111");
        dao.save(user);
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

    @GetMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {
       return service.findUserByLogin(principal.getName());
    }

}
