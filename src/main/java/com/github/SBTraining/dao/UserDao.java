package com.github.SBTraining.dao;

import com.github.SBTraining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findById(long id);

    User findByLogin(String login);
}
