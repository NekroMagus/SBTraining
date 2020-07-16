package com.github.SBTraining.controller.teapot;

import com.github.SBTraining.controller.chat.ChatController;
import com.github.SBTraining.exceptions.TeapotNotFoundException;
import com.github.SBTraining.model.Teapot;
import com.github.SBTraining.service.teapot.TeapotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TeapotRestController {

    static Logger log = Logger.getLogger(ChatController.class.getName());

    @Autowired
    private TeapotService service;


    @GetMapping("/api/teapot")
    public List<Teapot> findAllTeapot() {
        if (service.getAllTeapots().isEmpty()) {
            throw new TeapotNotFoundException("list teapots is empty");
        }
        return service.getAllTeapots();
    }


    @GetMapping("/api/teapot/{id}")
    public Teapot findByIdTeapot(@PathVariable("id") long id) {
        if (service.findTeapot(id) == null) {
            throw new TeapotNotFoundException("teapot not found");
        }
        return service.findTeapot(id);
    }


    @PostMapping("/api/teapot")
    public String createTeapot(@RequestBody Teapot teapot) {
        service.createTeapot(teapot);
        log.info("teapot created,teapot:" + teapot.toString());
        return "Teapot created";
    }


    @PutMapping("/api/teapot")
    public String updateTeapot(@RequestBody Teapot teapot) {
        service.updateTeapot(teapot);
        log.info("teapot updated,teapot:" + teapot.toString());
        return "teapot updated";
    }


    @DeleteMapping("/api/teapot/{id}")
    public String deleteTeapot(@PathVariable("id") long id) {
        if (service.findTeapot(id) == null) {
            throw new TeapotNotFoundException("чайник не найден");
        }
        service.deleteTeapot(id);
        log.info("teapot deleted,teapot:" + service.findTeapot(id).toString());
        return "teapot deleted";
    }


}
