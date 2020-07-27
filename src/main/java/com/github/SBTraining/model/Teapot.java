package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name = "Teapot")
public class Teapot implements Comparable<Teapot> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String model;
    private int power;
    private String color;
    private double volume;
    private String wayPhotoFile;
    private byte rating;

    @Override
    public String toString() {
        return "type:" + type +
                ",model:" + model +
                ",power:" + power +
                ",color:" + color +
                ",volume:" + volume +
                ",wayPhotoFile:" + wayPhotoFile +
                ",rating:" + rating;
    }

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

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public String getWayPhotoFile() {
        return wayPhotoFile;
    }

    public void setWayPhotoFile(String wayPhotoFile) {
        this.wayPhotoFile = wayPhotoFile;
    }

    @Override
    public int compareTo(Teapot teapot) {
        return teapot.rating - rating;
    }


}
