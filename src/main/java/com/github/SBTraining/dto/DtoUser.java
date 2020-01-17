package com.github.SBTraining.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.SBTraining.model.User;
import org.springframework.hateoas.RepresentationModel;

public class DtoUser extends RepresentationModel {
    private String email;
    private int balance;
    private String login;
    private String dateOfReg;
    @JsonCreator
    public DtoUser(User user) {
        this.email=user.getEmail();
        this.balance=user.getBalance();
        this.login=user.getLogin();
        this.dateOfReg=user.getDateOfRed();
    }
}
