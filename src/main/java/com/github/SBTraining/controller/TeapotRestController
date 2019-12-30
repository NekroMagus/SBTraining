package com.github.SBTraining.controller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import com.github.SBTraining.service.TeapotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TeapotRestController {
    @Autowired
    private TeapotDao dao;

    @Autowired
    private TeapotService teapotService;

    @GetMapping("/teapot")
    public List<Teapot> getAll() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void add() {
        Teapot teapot = new Teapot();
        teapot.setColor("Red");
        teapot.setModel("Sony");
        teapot.setPower(220);
        teapot.setType("Electronic");
        teapot.setVolume(2200);
        dao.save(teapot);
    }

    @PutMapping("/teapot")
    public void update(@PathVariable("id") long id) {
        Teapot teapot = dao.findById(id).get();
        teapotService.changeTeapot(teapot);
        dao.save(teapot);
    }

    @GetMapping("/teapot/{id}")
    public Teapot find(@PathVariable("id") long id) {
        return dao.findById(id).get();
    }

    @DeleteMapping("/teapot/{id}")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }

    @PostMapping("/teapot")
    public void create(@RequestBody Teapot teapot) {
        dao.save(teapot);
    }
}
