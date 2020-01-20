package com.github.SBTraining.controller;

import com.github.SBTraining.exceptions.EmptyListTeapotsException;
import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.exceptions.ModelNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(value= EmptyListTeapotsException.class)
    public String callEmptyListTeapotException() {
     return "пустой список чайников";
    }

    @ExceptionHandler(value = FieldNullException.class)
    public String callFieldNullException() {
        return "одно из полей пустое";
    }

    @ExceptionHandler(value = ModelNotFoundException.class)
    public String callModelNotFoundException() {
        return "объект не найден";
    }

}
