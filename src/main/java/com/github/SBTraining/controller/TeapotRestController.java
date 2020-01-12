package com.github.SBTraining.controller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.exceptioncheckers.TeapotExceptionChecker;
import com.github.SBTraining.exceptions.EmptyListTeapotsException;
import com.github.SBTraining.model.Teapot;
import com.github.SBTraining.service.TeapotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeapotRestController {

    @Autowired
    private TeapotDao dao;

   private final TeapotExceptionChecker TEAPOT_EXCEPTION_CHECKER = new TeapotExceptionChecker();

    @Autowired
    private TeapotService teapotService;

    @GetMapping("/teapot")
    public List<Teapot> findAllTeapot() {
        if(dao.findAll().isEmpty())new EmptyListTeapotsException("список чайников пуст");
        return dao.findAll();
    }

    @GetMapping("/teapot/{id}")
    public Teapot findByIdTeapot(@PathVariable("id") long id) {
        TEAPOT_EXCEPTION_CHECKER.checkExistenceObject(dao.findById(id));
        return dao.findById(id);
    }

    @PostMapping("/teapot")
    public void createTeapot(@RequestBody Teapot teapot) {
        TEAPOT_EXCEPTION_CHECKER.checkFields(teapot);
        dao.save(teapot);
    }

    @PutMapping("/teapot")
    public void updateTeapot(@RequestBody Teapot teapot) {
        TEAPOT_EXCEPTION_CHECKER.checkFields(teapot);
        teapotService.updateTeapot(teapot);
    }

    @DeleteMapping("/teapot/{id}")
    public void deleteTeapot(@PathVariable("id") long id) {
        TEAPOT_EXCEPTION_CHECKER.checkExistenceObject(dao.findById(id));
        dao.deleteById(id);
    }

}
