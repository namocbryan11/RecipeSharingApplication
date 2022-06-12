package com.example.demo.service;

public class loginValidation {

	public boolean userValidation(String username, String password) {
		if(username.equals("bryan@gmail.com") && password.equals("mypassword")) {
			System.out.print("correct credentials");
			return true;
		}else {
			System.out.println("incorrect credentials!");
			return false;
		}
	}
}
