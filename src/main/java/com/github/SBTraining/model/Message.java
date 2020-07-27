package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameUserFrom;
    private String value;

    public Message() {
    }

    public Message(String nameUserFrom, String value) {
        this.nameUserFrom = nameUserFrom;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUserFrom() {
        return nameUserFrom;
    }

    public void setNameUserFrom(String nameUserFrom) {
        this.nameUserFrom = nameUserFrom;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
