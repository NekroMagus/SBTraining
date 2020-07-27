package com.github.SBTraining.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Question")
public class Question implements Comparable<Question>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question;
    private String answer;

    @OneToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_right")
    private Question question_Right;

    @OneToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_left")
    private Question question_Left;

    @OneToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_super")
    private Question superQuestion;

    private long idQuestionnaire;

    public Question() {
    }

    public Question(String answer, String question, Question questionLeft, Question questionRight, Question superQuestion) {
        this.answer = answer;
        this.question_Left = questionLeft;
        this.question_Right = questionRight;
        this.superQuestion = superQuestion;
    }

    @Override
    public int compareTo(Question o) {
        return (int) (getId() - o.getId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestionLeft() {
        return question_Left;
    }

    public void setQuestionLeft(Question questionLeft) {
        this.question_Left = questionLeft;
    }

    public Question getQuestionRight() {
        return question_Right;
    }

    public void setQuestionRight(Question questionRight) {
        this.question_Right = questionRight;
    }

    public Question getSuperQuestion() {
        return superQuestion;
    }

    public void setSuperQuestion(Question superQuestion) {
        this.superQuestion = superQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(long idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "question:" + question +
                ",answer:" + answer;
    }
}
