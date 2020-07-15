package com.github.SBTraining.controller.admin;

import com.github.SBTraining.dao.RoleDao;
import com.github.SBTraining.model.Role;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminRestController {

    @Autowired
    private RoleDao dao;

    @Autowired
    private UserService service;

    @GetMapping("/admin/getAllUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/admin/deleteAllUsers")
    public void deleteAllUsers() {
        service.deleteAllUsers();
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return dao.findAll();
    }

    @GetMapping("/role")
    public void addRole() {
        dao.save(new Role(1L,"ADMIN"));
    }

}
