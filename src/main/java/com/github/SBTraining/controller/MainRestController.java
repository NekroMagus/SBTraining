package com.github.SBTraining.controller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

    private TeapotDao dao;

    @GetMapping("/")
    public String helloController() {
        return "Hi";
    }

    @GetMapping("/all")
    public List<Teapot> getAll() {
        return dao.findAll();
    }
}
