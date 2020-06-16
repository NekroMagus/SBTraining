package com.github.SBTraining.model;

import javax.persistence.*;
import java.util.TreeSet;

@Entity
@Table(name="Questionnaire")
public class Questionnaire {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   private TreeSet<Question> tree;
   @OneToOne(targetEntity = Question.class)
   @JoinColumn(name="currentQuestion_two")
   private Question currentQuestion_two;
   @OneToOne(targetEntity = Question.class)
   @JoinColumn(name="currentQuestion")
   private Question currentQuestion;
   @OneToOne(targetEntity = Question.class)
   @JoinColumn(name="mainQuestion")
   private Question mainQuestion;


   public Questionnaire() {
       tree=new TreeSet<>();
   }

    public Questionnaire(TreeSet<Question> tree, Question currentQuestion_two, Question currentQuestion, Question mainQuestion) {
        this.tree = tree;
        this.currentQuestion_two = currentQuestion_two;
        this.currentQuestion = currentQuestion;
        this.mainQuestion = mainQuestion;
    }

    public Questionnaire(TreeSet<Question> tree) {
      this.tree = tree;
   }


   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public TreeSet<Question> getTree() {
      return tree;
   }

   public void setTree(TreeSet<Question> tree) {
      this.tree = tree;
   }

   public Question getCurrentQuestion_two() {
      return currentQuestion_two;
   }

   public void setCurrentQuestion_two(Question currentQuestion_two) {
      this.currentQuestion_two = currentQuestion_two;
   }

   public Question getCurrentQuestion() {
      return currentQuestion;
   }

   public void setCurrentQuestion(Question currentQuestion) {
      this.currentQuestion = currentQuestion;
   }

   public Question getMainQuestion() {
      return mainQuestion;
   }

   public void setMainQuestion(Question mainQuestion) {
      this.mainQuestion = mainQuestion;
   }
}
