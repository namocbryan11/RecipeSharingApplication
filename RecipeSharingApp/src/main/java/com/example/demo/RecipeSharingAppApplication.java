package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RecipeSharingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingAppApplication.class, args);
	}
	
//	@GetMapping("/hello")
//	public String Hello() {
//		String name = "Mary Joyce Namoc";
//		return "Hello, " + name;
//	}
}
