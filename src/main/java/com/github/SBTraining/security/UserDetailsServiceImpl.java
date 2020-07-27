package com.github.SBTraining.security;

import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtUser;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.findUserByLogin(username);
        return JwtUser.fromUserEntityToCustomUserDetails(userEntity);
    }
}