package com.github.SBTraining.service.teapot;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeapotService {

    @Autowired
    private TeapotDao dao;

    public void updateTeapot(Teapot teapot) {
        Teapot dbTeapot = dao.findById(teapot.getId());
        dbTeapot.setVolume(teapot.getVolume());
        dbTeapot.setType(teapot.getType());
        dbTeapot.setPower(teapot.getPower());
        dbTeapot.setModel(teapot.getModel());
        dbTeapot.setColor(teapot.getColor());
        dao.save(dbTeapot);
    }

    public void createTeapot(Teapot teapot) {
        dao.save(teapot);
    }

    public void deleteTeapot(long id) {
        dao.deleteById(id);
    }

    public Teapot findTeapot(long id) {
        return dao.findById(id);
    }

    public List<Teapot> getAllTeapots() {
        return dao.findAll();
    }

    public Page<Teapot> getAllTeapotsWithPagination() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id"));
        return dao.findAll(pageable);
    }

    public List<Teapot> getGoodTeapots() {
        List<Teapot> list = dao.findAll();
        Collections.sort(list);
        return list;
    }

}
