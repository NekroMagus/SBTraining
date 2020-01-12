package com.github.SBTraining.exceptioncheckers;

import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.exceptions.NotFoundTeapotException;
import com.github.SBTraining.model.Model;
import com.github.SBTraining.model.User;

public class UserExceptionChecker implements ExceptionChecker {

    @Override
    public void checkFields(Model model) {
        User user = (User) model;
       if(user.getDateOfRed()==null || user.getEmail()==null || user.getLogin()==null || user.getPassword()==null)new FieldNullException("одно из полей пустое");
    }

    @Override
    public void checkExistenceObject(Model model) {
        if(model==null)new NotFoundTeapotException("юзер не найден");
    }
}
