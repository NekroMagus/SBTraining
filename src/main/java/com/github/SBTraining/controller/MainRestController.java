package com.github.SBTraining.controller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    private TeapotDao dao;

    @GetMapping("/")
    public String helloController() {
        return "Hi";
    }

    @GetMapping("/all")
    public List<Teapot> getAll() {
        return dao.findAll();
    }

    @GetMapping("/add")
    public void add() {
        Teapot teapot = new Teapot();
        teapot.setColor("Red");
        teapot.setModel("Sony");
        teapot.setPower(220);
        teapot.setType("Electronic");
        teapot.setVolume(2200);
        dao.save(teapot);
    }
}
