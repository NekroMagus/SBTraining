package com.github.SBTraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String dateOfReg;
    public void setId(long id) {
        this.id=id;
    }
    public long getId() {
        return id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword(String password) {
        return password;
    }
    public void setDateOfReg(String dateOfReg) {
        this.dateOfReg=dateOfReg;
    }
    public String getDateOfRed() {
        return dateOfReg;
    }
}
