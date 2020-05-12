package com.github.SBTraining.controller.authorization;


import com.github.SBTraining.model.AuthenticationModel;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.JwtTokenProvider;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthorizationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationModel model) {
        String login = model.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, model.getPassword()));
        User user = userService.findUserByLogin(login);
        String token = jwtTokenProvider.createToken(login, user.getRole());
        Map<Object, Object> response = new HashMap<>();
        response.put("login", login);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

}