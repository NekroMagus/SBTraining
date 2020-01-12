package com.github.SBTraining.exceptioncheckers;

import com.github.SBTraining.model.Model;

public interface ExceptionChecker {
    void checkFields(Model model);
    void checkExistenceObject(Model model);
}
