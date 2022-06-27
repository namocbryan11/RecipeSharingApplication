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
import com.example.demo.repository.UserRepositoryCustom;
import com.example.demo.service.loginValidation;

@RestController
@RequestMapping("/user/")
@CrossOrigin("http://localhost:8081/")
public class UserController {
	
	@Autowired
	private UserRegistrationCustom userRegistration;
	
	@Autowired 
	private loginValidation loginvalidation;
	
	@Autowired
	private UserRepositoryCustom userRepository;
	
	@PostMapping("/register")
	public boolean registerUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) throws IOException {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		return userRegistration.registerUser(newUser);
	}
	
	@PostMapping("/login")
	public boolean loginUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Login login) {	
		System.out.print("entered");
		String email = login.getEmail();
		String password = login.getPassword();
		
		request.getSession().setAttribute("myemail", email);
		System.out.print(request.getSession().getId());
		try {
			return loginvalidation.userValidation(email, password);
		}catch(Exception e) {
			System.out.print(e.getMessage().toString());
			return false;
		}
	}
	
	@PostMapping("/profile/edit/{Id}")
	private boolean editProfile(@RequestBody User user, @PathVariable Long Id){
		try {
			userRepository.editUserById(user, Id);
			return true;
		}catch(Exception ex) {
			System.out.print("Error: " + ex.getMessage().toString());
			return false;
		}	
	}
	
	@GetMapping("/{email}")
	private User findUserByEmail(@PathVariable String email) {	
		return userRepository.findUserByEmail(email);
	}
}
