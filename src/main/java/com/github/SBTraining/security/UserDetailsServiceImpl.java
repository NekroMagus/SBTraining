package com.github.SBTraining.security;

import com.github.SBTraining.dao.UserDao;
import com.github.SBTraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao dao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findByLogin(username);
        return null;
    }
}
