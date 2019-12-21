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
    @PutMapping("/update")
    public void update(@PathVariable(name="id" , required = false) String id,@PathVariable(name="method",required = false) String method,@PathVariable(name = "value",required = false) String value) {
        Optional<Teapot> teapotList = dao.findById(Long.parseLong(id));
        Teapot teapot = teapotList.get();
        if(method.equals("Color"))teapot.setColor(value);
        else if(method.equals("Model"))teapot.setModel(value);
        else if(method.equals("Power"))teapot.setPower(Integer.parseInt(value));
        else if(method.equals("Type"))teapot.setType(value);
        else if(method.equals("Volume"))teapot.setVolume(Integer.parseInt(value));
        dao.save(teapot);
    }
    @GetMapping("/find")
    public Optional<Teapot> find(@RequestParam(name = "id",required = false) String id) {
        return dao.findById(Long.parseLong(id));
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam(name = "id",required = false) String id) {

        dao.deleteById(Long.parseLong(id));
    }
    @PostMapping("/create")
    public void create(@RequestBody Teapot teapot) {
        dao.save(teapot);
    }
}
