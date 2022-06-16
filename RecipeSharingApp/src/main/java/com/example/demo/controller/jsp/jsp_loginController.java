package com.example.demo.controller.jsp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RecipeMethods;
import com.example.demo.service.loginValidation;

@Controller
@RequestMapping("/jsp/")
public class jsp_loginController {
	
	loginValidation login_validation = new loginValidation();
	@Autowired
	RecipeMethods recipeMethods = new RecipeMethods();
	
	@GetMapping("/login")
	public String login() {
		return "Hello";
	}
	@GetMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		request.getSession().setAttribute("recipes", recipeMethods.getRecipes());
		return "Welcome";
	}
	
	@PostMapping("/welcome")
	public void welcome(HttpServletRequest request,HttpServletResponse response
			, @RequestParam(value="email", required=false) String email, 
			@RequestParam(required=false) String password) throws IOException {
		if(login_validation.userValidation(email, password)) {
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("password", password);
			request.getSession().setAttribute("recipes", recipeMethods.getRecipes());
			response.sendRedirect("/jsp/welcome");
		}else {
			response.sendRedirect("/jsp/login");
		}
	}
	
}
