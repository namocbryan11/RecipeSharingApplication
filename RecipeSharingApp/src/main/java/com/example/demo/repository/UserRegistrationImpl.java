package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Repository
public class UserRegistrationImpl implements UserRegistrationCustom {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		try {
			String email = user.getEmail();
			String password = user.getPassword();
			System.out.print(email);
			this.jdbcTemplate.update("INSERT INTO USERS(EMAIL,PASSWORD) VALUES(?,?)",email,password);
			return true;
		}catch(Exception e) {
			System.out.print(e.getMessage().toString());
			return false;
		}
		
	}

}
