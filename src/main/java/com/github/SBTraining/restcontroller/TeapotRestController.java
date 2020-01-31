package com.github.SBTraining.restcontroller;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.exceptions.EmptyListTeapotsException;
import com.github.SBTraining.exceptions.ModelNotFoundException;
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


    @GetMapping("/teapot")
    public List<Teapot> findAllTeapot() {
        if(dao.findAll().isEmpty()) {
            throw new EmptyListTeapotsException("список чайников пуст");
        }
        return dao.findAll();
    }


    @GetMapping("/api/teapot/{id}")
    public Teapot findByIdTeapot(@PathVariable("id") long id) {
        if(dao.findById(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
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
        if(dao.findById(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        dao.deleteById(id);
    }


}
