package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;

    @JoinColumn(name="user_id")
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
