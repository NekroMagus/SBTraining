package com.github.SBTraining.dao;

import com.github.SBTraining.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {
      List<Comment> findAllByIdTeapot(long idTeapot);
}