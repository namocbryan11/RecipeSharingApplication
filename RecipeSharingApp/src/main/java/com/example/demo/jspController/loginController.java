package com.example.demo.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Login;

@Controller
@RequestMapping("/jsp/")
public class loginController {
	
	@GetMapping("/login")
	public String login() {
		return "Hello";
	}
//	@PostMapping("/welcome")
//	public Login login(@RequestParam(value="email", defaultValue="World") String email, 
//			@RequestParam(required=false) String password, Login login) {
//		login.setEmail(email);
//		login.setEmail(password);
//		return login;
//	}
}
