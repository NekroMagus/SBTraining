package com.github.SBTraining.dao;

import com.github.SBTraining.model.Teapot;
import javafx.scene.control.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeapotDao extends JpaRepository<Teapot, Long> {

    Teapot findById(long id);

    Page<Teapot> findAll(Pageable pageable);
}
