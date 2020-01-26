package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name="Teapot")
public class Teapot  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private String model;
    private String color;
    private double volume;
    private int power;
    
    //TODO: need add to annotation @ManyToOne for List<Message> in this class

    public Teapot() {
    }

    public Teapot(String type, String model, String color, double volume, int power) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.volume = volume;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
