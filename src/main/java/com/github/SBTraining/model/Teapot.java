package com.github.SBTraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teapot {

    private long id;
    private String type;
    private String model;
    private String color;
    private double volume;
    private int power;
}
