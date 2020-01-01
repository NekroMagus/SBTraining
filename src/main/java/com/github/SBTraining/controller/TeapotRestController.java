package com.github.SBTraining.controller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import com.github.SBTraining.service.TeapotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeapotRestController {

    @Autowired
    private TeapotDao dao;

    @Autowired
    private TeapotService teapotService;
    @GetMapping("/add")
    public void add() {
        Teapot t = new Teapot();
        t.setType("edadasg");
        t.setColor("1231231");
        t.setVolume(12.2);
        t.setPower(123);
        t.setModel("sgag");
        dao.save(t);
    }
    @GetMapping("/teapot")
    public List<Teapot> findAllTeapot() {
        return dao.findAll();
    }

    @GetMapping("/teapot/{id}")
    public Teapot findByIdTeapot(@PathVariable("id") long id) {
        return dao.findById(id);
    }

    @PostMapping("/teapot")
    public void createTeapot(@RequestBody Teapot teapot) {
        dao.save(teapot);
    }

    @PutMapping("/teapot")
    public void updateTeapot(@RequestBody Teapot teapot) {
        teapotService.updateTeapot(teapot);
    }

    @DeleteMapping("/teapot/{id}")
    public void deleteTeapot(@PathVariable("id") long id) {
        dao.deleteById(id);
    }

}
