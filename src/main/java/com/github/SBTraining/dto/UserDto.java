package com.github.SBTraining.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.SBTraining.model.User;
import lombok.Data;

@Data
public class UserDto {

    private String login;
    private String password;
    private String email;

    @JsonCreator
    public UserDto(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "login:" + login +
                        ",password:" + password +
                        ",email:" + email;
    }
}
