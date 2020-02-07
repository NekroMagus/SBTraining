package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment implements Comparable<Comment> {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String text;
   private String name;
   private String dateCreate;
   private byte estimation;

   @ManyToOne(cascade = CascadeType.ALL)
   private Teapot teapot;

   public Comment() {}

   public Comment(long id,String text,String name,String dateCreate,byte estimation) {
      this.id=id;
      this.name=name;
      this.dateCreate=dateCreate;
      this.estimation=estimation;
   }

   @Override
   public int compareTo(Comment o) {
      return o.getEstimation()-estimation;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDateCreate() {
      return dateCreate;
   }

   public void setDateCreate(String dateCreate) {
      this.dateCreate = dateCreate;
   }

   public byte getEstimation() {
      return estimation;
   }

   public void setEstimation(byte estimation) {
      this.estimation = estimation;
   }
}
