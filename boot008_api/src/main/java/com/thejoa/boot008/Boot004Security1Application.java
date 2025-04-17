package com.thejoa.boot008;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Boot004Security1Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot004Security1Application.class, args);
	}

}
