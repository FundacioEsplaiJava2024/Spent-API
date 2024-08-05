package com.grupo.spent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpentApplication.class, args);
	}
}
