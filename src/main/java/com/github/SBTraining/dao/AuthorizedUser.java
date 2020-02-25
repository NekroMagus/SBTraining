package com.github.SBTraining.dao;

import com.github.SBTraining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedUser extends JpaRepository<User,Long> {

}
