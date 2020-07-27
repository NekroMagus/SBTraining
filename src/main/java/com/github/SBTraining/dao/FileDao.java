package com.github.SBTraining.dao;


import com.github.SBTraining.model.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDao extends JpaRepository<UserFile, Long> {

    UserFile findById(long id);

}
