package com.github.SBTraining.restcontroller;


import com.github.SBTraining.exceptions.EmptyListTeapotsException;
import com.github.SBTraining.exceptions.ModelNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(value= EmptyListTeapotsException.class)
    public String callEmptyListTeapotException() {
     return "пустой список чайников";
    }

    @ExceptionHandler(value = ModelNotFoundException.class)
    public String callModelNotFoundException() {
        return "объект не найден";
    }

}
