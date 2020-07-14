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

    static Logger logger = Logger.getLogger(AuthorizationRestController.class.getName());

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<?> reg(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        String token = jwtProvider.generateToken(user.getLogin());
        return ResponseEntity.ok("Bearer " + token);
    }

    @PostMapping("/login")
    public boolean auth(@RequestBody User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
        return true;
    }

    @PostMapping("/check")
    public String check(@RequestBody User user) {
        if(userService.findUserByLogin(user.getLogin())!=null) {
            return jwtProvider.generateToken(user.getLogin());
        }
        else {
            return "null";
        }
    }

}