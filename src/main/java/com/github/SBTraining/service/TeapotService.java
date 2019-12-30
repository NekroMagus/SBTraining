package com.github.SBTraining.service;

import com.github.SBTraining.model.Teapot;
import org.springframework.stereotype.Service;

@Service
public class TeapotService {
  public void changeTeapot(Teapot teapot) {
    teapot.setColor(getColorFromPage());
    teapot.setVolume(getVolumeFromPage());
    teapot.setPower(getPowerFromPage());
    teapot.setModel(getModelFromPage());
    teapot.setType(getTypeFromPage());
  }
  public String getTypeFromPage() {
    // получаем тип , который введёт пользователь
    return new String("type");
  }
  public String getModelFromPage() {
    // получаем модель, который введёт пользователь
    return new String("model");
  }
  public String getColorFromPage() {
    // получаем цвет , который введёт пользователь
    return new String("color");
  }
  public double getVolumeFromPage() {
    // получаем звук , который введёт пользователь
    return 0.0;
  }
  public int getPowerFromPage() {
    // получаем количество энергии, которое введёт пользователь
    return 100;
  }
}
