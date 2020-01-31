package com.github.SBTraining.model;

import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment implements Comparable<Comment> {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private long idTeapot;
   private String text;
   private String name;
   private String dateCreate;
   private byte estimation;

   public Comment() {}

   public Comment(long id,long idTeapot,String text,String name,String dateCreate,byte estimation) {
      this.id=id;
      this.idTeapot=idTeapot;
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

   public long getIdTeapot() {
      return idTeapot;
   }

   public void setIdTeapot(long idTeapot) {
      this.idTeapot = idTeapot;
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
