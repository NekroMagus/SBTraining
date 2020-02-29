package com.github.SBTraining.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Teapot")
public class Teapot implements Comparable<Teapot> {

    //TODO: you should delete column annotation if variable.name == Column.name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "power")
    private int power;

    @Column(name = "color")
    private String color;

    @Column(name = "volume")
    private double volume;

    @Column(name = "wayphotofile")
    private String wayPhotoFile;

    @Column(name = "rating")
    private byte rating;

    @Column(name = "listcomments")
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "teapot")
    private List<Comment> listComments;

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

    @Override
    public int compareTo(Teapot teapot) {
        return teapot.rating - rating;
    }

    public String getWayPhotoFile() {
        return wayPhotoFile;
    }

    public void setWayPhotoFile(String wayPhotoFile) {
        this.wayPhotoFile = wayPhotoFile;
    }

    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }
}
