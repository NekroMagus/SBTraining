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


    @GetMapping("/teapot/{id}")
    public Teapot find(@PathVariable("id") long id) {
        return dao.findById(id);
    }

    @PostMapping("/teapot")
    public void create(@RequestBody Teapot teapot) {
        dao.save(teapot);
    }

    @PutMapping("/teapot")
    public void update(@RequestBody Teapot teapot) {
        Teapot dbTeapot = dao.findById(teapot.getId());
        teapotService.updateTeapot(dbTeapot, teapot);
        dao.save(dbTeapot);
    }
    @DeleteMapping("/teapot/{id}")
    public void delete(@PathVariable("id") long id) {
        dao.deleteById(id);
    }

}
