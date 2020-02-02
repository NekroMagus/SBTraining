package com.github.SBTraining.controller.exception;

import com.github.SBTraining.exceptions.ModelNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

   @ExceptionHandler(value = ModelNotFoundException.class)
    public String callModelNotFoundException() {
        return "объект не найден";
    }

}
