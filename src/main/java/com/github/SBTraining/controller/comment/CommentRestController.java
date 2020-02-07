package com.github.SBTraining.controller.comment;

import com.github.SBTraining.dao.CommentDao;
import com.github.SBTraining.model.Comment;
import com.github.SBTraining.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentRestController {

    @Autowired
    private CommentDao dao;

   @Autowired
    private CommentService service;

    @GetMapping("/comment/{id}")
    public List<Comment> getAllComments(@PathVariable("id") long id) {
          return service.getComments(id);
    }

    @PostMapping("/comment")
    public void createComment(@RequestBody Comment comment) {
        service.createComment(comment);
    }

    @PutMapping("/comment")
    public void updateComment(@RequestBody Comment comment) {
        service.updateComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable("id") long id) {
        service.deleteComment(id);
    }

}
