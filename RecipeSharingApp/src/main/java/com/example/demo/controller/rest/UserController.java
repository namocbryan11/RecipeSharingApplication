package com.example.demo.controller.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.UserRegistrationCustom;
import com.example.demo.service.loginValidation;

@RestController
@RequestMapping("/user/")
@CrossOrigin("http://localhost:8081/")
public class UserController {
	
	@Autowired
	private UserRegistrationCustom userRepository;
	
	@Autowired 
	private loginValidation loginvalidation;
	
	@PostMapping("/register")
	public boolean registerUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) throws IOException {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		return userRepository.registerUser(newUser);
	}
	@PostMapping("/login")
	public boolean loginUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Login login) {
		String email = login.getEmail();
		String password = login.getPassword();
		try {
			return loginvalidation.userValidation(email, password);
		}catch(Exception e) {
			System.out.print(e.getMessage().toString());
			return false;
		}

	}
}
