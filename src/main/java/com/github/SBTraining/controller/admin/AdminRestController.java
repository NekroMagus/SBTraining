package com.github.SBTraining.controller.admin;

import com.github.SBTraining.model.Role;
import com.github.SBTraining.model.User;
import com.github.SBTraining.service.admin.AdminService;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class AdminRestController {

    static Logger log = Logger.getLogger(AdminRestController.class.getName());

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/admin/deleteAllUsers")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        log.info("All users deleted");
        return "all users deleted";
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return adminService.getAllRoles();
    }

    @PostMapping("/role")
    public String addRole(@RequestBody Role role) {
        adminService.addRole(new Role(1L,"ADMIN"));
        log.info("Role added,role:"+role.toString());
        return "role added";
    }

}
