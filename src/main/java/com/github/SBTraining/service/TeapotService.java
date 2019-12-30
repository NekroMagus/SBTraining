package com.github.SBTraining.service;

import com.github.SBTraining.model.Teapot;
import org.springframework.stereotype.Service;

@Service
public class TeapotService {

  public void updateTeapot(Teapot oldTeapot, Teapot newTeapot) {
    oldTeapot.setVolume(newTeapot.getVolume());
    oldTeapot.setType(newTeapot.getType());
    oldTeapot.setPower(newTeapot.getPower());
    oldTeapot.setModel(newTeapot.getModel());
    oldTeapot.setColor(newTeapot.getColor());
  }
}
