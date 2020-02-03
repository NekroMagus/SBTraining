package com.github.SBTraining.controller.exception;

import com.github.SBTraining.exceptions.TeapotNotFoundException;
import com.github.SBTraining.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

   @ExceptionHandler(value = TeapotNotFoundException.class)
    public String callTeapotNotFoundException() {
        return "чайник не найден";
    }

    @ExceptionHandler(value= UserNotFoundException.class)
    public String callUserNotFoundException() {return "пользователь не найден";}
}
