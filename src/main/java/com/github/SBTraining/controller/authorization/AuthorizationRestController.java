package com.github.SBTraining.controller.authorization;


import com.github.SBTraining.controller.admin.AdminRestController;
import com.github.SBTraining.dto.UserDto;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtProvider;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class AuthorizationRestController {

    static Logger log = Logger.getLogger(AuthorizationRestController.class.getName());

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String registration(@RequestBody UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(new User(user.getLogin(),user.getPassword(),user.getEmail()));
        log.info("user added , user:" + user.toString());
        return createToken(new User(user.getLogin(),user.getPassword(),user.getEmail()));
    }


    @PostMapping("/login")
    public void auth(@RequestBody UserDto user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
        log.info("user authenticated , user:" + user.toString());
    }

    @PostMapping("/createToken")
    public String createToken(@RequestBody User user) {
        return jwtProvider.generateToken(user.getLogin());
    }

}