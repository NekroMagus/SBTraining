package com.github.SBTraining.dao;

import com.github.SBTraining.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {

      Comment findById(long id);

}
