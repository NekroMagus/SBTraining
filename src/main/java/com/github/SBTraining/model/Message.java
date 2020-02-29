package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {

    //TODO: you should delete column annotation if variable.name == Column.name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "id_User")
    @ManyToOne()
    private User user;

    public Message() {
    }

    public Message(long id, String text) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
