package com.github.SBTraining.model;

import com.github.SBTraining.dto.UserDto;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private int balance;
    private String login;
    private String password;
    private String regDate;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(targetEntity = UserFile.class)
    @JoinColumn(name = "files")
    private List<UserFile> listFiles;

    public User() {
    }
    
    public User(String email, int balance, String login, String password, String regDate) {
        this.email = email;
        this.balance = balance;
        this.login = login;
        this.password = password;
        this.regDate = regDate;
    }

    public User(UserDto user) {
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.login=user.getLogin();
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<UserFile> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<UserFile> listFiles) {
        this.listFiles = listFiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        User u = (User) o;
        return this.getLogin() == u.getLogin() && this.getPassword() == u.getPassword() &&
                this.getRegDate() == u.getRegDate() && this.getEmail() == u.getEmail() &&
                this.getBalance() == u.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, regDate, email, balance);
    }

    @Override
    public String toString() {
        return "id:" + id +
                ",login:" + login +
                ",password:" + password +
                ",regdate:" + regDate +
                ",email:" + email +
                ",balance:" + balance +
                ",role:" + role;
    }
}
