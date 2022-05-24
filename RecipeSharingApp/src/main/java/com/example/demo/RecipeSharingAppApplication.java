package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RecipeSharingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingAppApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String Hello() {
		String name = "Mary Joyce Namoc";
		return "Hello, " + name;
	}
}
