package com.github.SBTraining.service;

import com.github.SBTraining.dao.CommentDao;
import com.github.SBTraining.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

   @Autowired
    private CommentDao dao;

   public void updateComment(Comment comment) {
       Comment dbComment = dao.findById(comment.getId());
       dbComment.setIdTeapot(comment.getIdTeapot());
       dbComment.setText(comment.getText());
       dbComment.setEstimation(comment.getEstimation());
       dbComment.setDateCreate(comment.getDateCreate());
       dbComment.setName(comment.getName());
       dao.save(dbComment);
   }

}