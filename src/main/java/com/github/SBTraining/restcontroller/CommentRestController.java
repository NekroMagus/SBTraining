package com.github.SBTraining.restcontroller;

import com.github.SBTraining.dao.CommentDao;
import com.github.SBTraining.model.Comment;
import com.github.SBTraining.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
public class CommentRestController {

   @Autowired
    private CommentDao dao;

   @Autowired
    private CommentService service;

    @GetMapping("/comment/{id}")
    public List<Comment> getAllComments(@PathVariable("id") long idTeapot) {
        List<Comment> list = dao.findAllByIdTeapot(idTeapot);
        Collections.sort(list);
        return list;
    }

    @PostMapping("/comment")
    public void createComment(@RequestBody Comment comment) {
        dao.save(comment);
    }

    @PutMapping("/comment")
    public void updateComment(@RequestBody Comment comment) {
        service.updateComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable("id") long id) {
        dao.deleteById(id);
    }

}
