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

    @Autowired
    private Service service;

    @GetMapping("/")
    public String helloController() {
        return "Hi";
    }

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
    public void update(@RequestBody Teapot newTeapot) {
        Teapot teapot = dao.findById(id).get();
        service.changeTeapot(newTeapot); //Для чего это строка, если в итоге сохраняем другой объект?
        dao.save(teapot);
    }

    @GetMapping("/teapot/{id}")
    public Teapot find(@PathVariable("id") Long id) {
        return dao.findById(id).get();
    }

    @DeleteMapping("/teapot/{id}")
    public void delete(@PathVariable("id") Long id) {
        dao.deleteById(id);
    }

    @PostMapping("/teapot")
    public void create(@RequestBody Teapot teapot) {
        dao.save(teapot);
    }
}
