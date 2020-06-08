package com.github.SBTraining.controller.authorization;


import com.github.SBTraining.model.AuthenticationModel;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtTokenProvider;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity auth(@RequestBody AuthenticationModel model) {
        User userEntity = userService.findUserByLogin(model.getLogin());
        String token = jwtTokenProvider.generateToken(userEntity.getLogin());
        return ResponseEntity.ok(token);
    }

}