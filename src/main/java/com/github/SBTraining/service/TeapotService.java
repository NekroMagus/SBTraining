package com.github.SBTraining.service;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import org.springframework.beans.factory.annotation.Autowired;
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

  public Teapot getGoodTeapot(long id) {
      List<Teapot> list = dao.findAll();
      Collections.sort(list);
      return list.get((int) id);
  }
}
