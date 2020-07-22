package com.github.SBTraining;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbTrainingApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(SbTrainingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SbTrainingApplication.class);
    }
}
