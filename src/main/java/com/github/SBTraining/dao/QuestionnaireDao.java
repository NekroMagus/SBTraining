package com.github.SBTraining.dao;


import com.github.SBTraining.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionnaireDao extends JpaRepository<Questionnaire,Long> {

    Questionnaire findById(long id);
}
