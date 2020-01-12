package com.github.SBTraining.exceptioncheckers;

import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.exceptions.NotFoundTeapotException;
import com.github.SBTraining.model.Model;
import com.github.SBTraining.model.Teapot;

public class TeapotExceptionChecker implements ExceptionChecker {

    @Override
    public void checkFields(Model model) {
        Teapot teapot = (Teapot) model;
        if(teapot.getColor()==null || teapot.getModel()==null || teapot.getPower()==0 || teapot.getType()==null ||
                teapot.getVolume()==0.0)new FieldNullException("одно из полей равно null");
    }

    @Override
    public void checkExistenceObject(Model model) {
        if(model==null)new NotFoundTeapotException("чайник не найден");
    }
}
