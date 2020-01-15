package com.github.SBTraining.controller;

import com.github.SBTraining.exceptions.EmptyListTeapotsException;
import com.github.SBTraining.exceptions.FieldNullException;
import com.github.SBTraining.exceptions.ModelNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {
    @ExceptionHandler(value= EmptyListTeapotsException.class)
    public String callELTException() {
     return "пустой список чайников";
    }
    @ExceptionHandler(value = FieldNullException.class)
    public String callFNException() {
        return "одно из полей пустое";
    }
    @ExceptionHandler(value = ModelNotFoundException.class)
    public String callNFMException() {
        return "объект не найден";
    }
}
