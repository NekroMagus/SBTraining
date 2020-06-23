package com.github.SBTraining.dao;

import com.github.SBTraining.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Long> {

    Message findById(long id);

}
