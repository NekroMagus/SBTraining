package com.github.SBTraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
