package ru.irtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdviserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdviserApplication.class, args);
	}
}
