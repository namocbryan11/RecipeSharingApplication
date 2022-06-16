package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;

@Repository
public class UserLoginImpl implements UserLoginCustom{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getUserByEmailAndPassword(String email, String password) {
		List<User> users = null;
		try {
			users = jdbcTemplate.query("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?", BeanPropertyRowMapper.newInstance(User.class), email,password);
		}catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
		return users;

	}

}
