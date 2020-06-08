package com.github.SBTraining.security;


import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtUser;
import com.github.SBTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User jwtUser = userService.findUserByLogin(username);
        return JwtUser.fromUserEntityToCustomUserDetails(jwtUser);
    }
}
