package com.github.SBTraining.controller.authorization;

import com.github.SBTraining.model.User;
import com.github.SBTraining.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationRestController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/checkUser")
    public boolean checkUser(@RequestBody User user) {
        return service.checkUser(user);
    }

    @PostMapping("/addAuthorizedUser")
    public void saveUser(@RequestBody User user) {
        service.saveUser(user);
    }
}
