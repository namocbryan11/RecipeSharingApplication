package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserLoginCustom;

@Service
public class loginValidation {

	@Autowired
	private UserLoginCustom userLoginCustom;
	
	public boolean userValidation(String username, String password) {
		if(userLoginCustom.getUserByEmailAndPassword(username, password).size() > 0) {
			System.out.print("correct credentials");
			return true;
		}else {
			System.out.println("incorrect credentials!");
			return false;
		}
	}
}
