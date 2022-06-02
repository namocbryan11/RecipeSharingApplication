package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;

@RestController
@RequestMapping("/api/")
public class Rest_LoginController {
	
	@PostMapping("/login")
	public Login loginPage(@RequestParam(value="email", defaultValue="World") String email, 
			@RequestParam(required=false) String password, Login login) {
			login.setEmail(email);
			login.setPassword(password);
			return login;
	}
}
