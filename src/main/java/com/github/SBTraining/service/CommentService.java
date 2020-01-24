package com.github.SBTraining.service;

import com.github.SBTraining.dao.CommentDao;
import com.github.SBTraining.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> getAllComments(long id) {
        return commentDao.findAllByIdTeapot(id);
    }

    public List<Comment> getGoodComments(long id) {
        List<Comment> listAllComments = commentDao.findAllByIdTeapot(id);
        List<Comment> listGoodComments = new ArrayList<>();
        Collections.sort(listAllComments);
        for(int i=0;i<=2;i++) {
            listGoodComments.add(listAllComments.get(i));
        }
        return listGoodComments;
    }
}
