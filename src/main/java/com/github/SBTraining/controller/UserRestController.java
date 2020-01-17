package com.github.SBTraining.controller;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.dto.DtoUser;
import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.exceptions.ModelNotFoundException;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.annotations.common.util.StringHelper.add;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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
        if(user.getDateOfRed()==null || user.getEmail()==null || user.getLogin()==null || user.getPassword()==null)new FieldNullException("одно из полей пустое");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
    @GetMapping("/user/{id}")
    public DtoUser find(@PathVariable("id") long id) {
        if(dao.findById(id)==null)new ModelNotFoundException("юзер не найден");
        DtoUser dtoUser = new DtoUser(dao.findById(id));
        add(linkTo(methodOn(UserRestController.class).?.withSelfRel());
        return dtoUser;
    }



    @PutMapping("/user")
    public void update(@RequestBody User user)  {
        if(user.getDateOfRed()==null || user.getEmail()==null || user.getLogin()==null || user.getPassword()==null)new FieldNullException("одно из полей пустое");
        userService.update(user);
    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        if(dao.findById(id)==null)new ModelNotFoundException("юзер не найден");
        dao.deleteById(id);
    }

}
