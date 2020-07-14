package com.github.SBTraining.controller.authorization;


import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtProvider;
import com.github.SBTraining.security.jwt.JwtTokenFilter;
import com.github.SBTraining.service.UserService;
import jdk.nashorn.internal.objects.annotations.Function;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AuthorizationRestController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String registration(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        return createToken(user);
    }


    @PostMapping("/login")
    public void auth(@RequestBody User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
    }

    @PostMapping("/createToken")
    public String createToken(@RequestBody User user) {
        return jwtProvider.generateToken(user.getLogin());
    }

}