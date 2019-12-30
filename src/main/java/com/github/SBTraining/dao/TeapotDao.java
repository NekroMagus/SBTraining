package com.github.SBTraining.dao;

import com.github.SBTraining.model.Teapot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeapotDao extends JpaRepository<Teapot, Long> {
    Teapot findById(long id);
}
