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
    private TeapotService service;


    @GetMapping("/teapot")
    public List<Teapot> findAllTeapot() {
        if(service.getAllTeapots().isEmpty()) {
            throw new ModelNotFoundException("список чайников пуст");
        }
        return service.getAllTeapots();
    }


    @GetMapping("/api/teapot/{id}")
    public Teapot findByIdTeapot(@PathVariable("id") long id) {
        if(service.findTeapot(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        return service.findTeapot(id);
    }


    @PostMapping("/teapot")
    public void createTeapot(@RequestBody Teapot teapot) {
        service.createTeapot(teapot);
    }


    @PutMapping("/teapot")
    public void updateTeapot(@RequestBody Teapot teapot) {
        service.updateTeapot(teapot);
    }


    @DeleteMapping("/teapot/{id}")
    public void deleteTeapot(@PathVariable("id") long id) {
        if(service.findTeapot(id)==null) {
            throw new ModelNotFoundException("объект не найден");
        }
        service.deleteTeapot(id);
    }



}
