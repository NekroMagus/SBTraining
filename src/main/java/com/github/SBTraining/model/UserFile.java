package com.github.SBTraining.model;


import javax.persistence.*;

@Entity
@Table(name="files")
public class UserFile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nameFile;
    private String type;
    private byte[] content;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public UserFile() {
    }

    public UserFile(String nameFile,String type,byte[] content) {
        this.nameFile=nameFile;
        this.type=type;
        this.content=content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
