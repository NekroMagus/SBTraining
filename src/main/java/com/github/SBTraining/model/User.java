package com.github.SBTraining.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private long id;

    @Column(name="email")
    private String email;

    @Column(name="balance")
    private int balance;

    @Column(name="login",unique = true)
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="regdate")
    private String regDate;

    @Column(name="messagelist")
    @OneToMany(cascade=CascadeType.REFRESH,mappedBy = "user")
    private List<Message> messageList;

    public User() {}

    public User(String email,int balance,String login,String password,String regDate) {
        this.email=email;
        this.balance=balance;
        this.login=login;
        this.password=password;
        this.regDate=regDate;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }


    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o.getClass()!=this.getClass()) return false;
        User u = (User) o;
        return this.getLogin()==u.getLogin() && this.getPassword()==u.getPassword() &&
               this.getRegDate()==u.getRegDate() && this.getEmail()==u.getEmail() &&
               this.getBalance()==u.getBalance() && this.getMessageList()==u.getMessageList();
    }

    @Override
    public int hashCode() {
        return Objects.hash(login,password,regDate,email,balance,messageList);

    }

}
