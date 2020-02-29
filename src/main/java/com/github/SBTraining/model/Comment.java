package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment implements Comparable<Comment> {

    //TODO: you should delete column annotation if variable.name == Column.name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "name")
    private String name;

    @Column(name = "datecreate")
    private String dateCreate;

    @Column(name = "estimation")
    private byte estimation;

    @JoinColumn(name = "id_Teapot")
    @ManyToOne()
    private Teapot teapot;

    public Comment() {
    }

    public Comment(long id, String text, String name, String dateCreate, byte estimation) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.estimation = estimation;
    }

    @Override
    public int compareTo(Comment o) {
        return o.getEstimation() - estimation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public byte getEstimation() {
        return estimation;
    }

    public void setEstimation(byte estimation) {
        this.estimation = estimation;
    }
}
