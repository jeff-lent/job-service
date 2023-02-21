package com.xloop.resourceloop.createJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CreateJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateJobApplication.class, args);
	}

}
