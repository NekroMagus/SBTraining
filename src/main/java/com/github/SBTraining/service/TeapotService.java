package com.github.SBTraining.service;

import com.github.SBTraining.dao.TeapotDao;
import com.github.SBTraining.model.Teapot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
