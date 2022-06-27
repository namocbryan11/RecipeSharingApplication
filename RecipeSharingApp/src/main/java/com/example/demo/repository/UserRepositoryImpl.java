package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void editUserById(User user, Long Id) {
		String email = user.getEmail();
		String fname = user.getFname();
		String lname = user.getLname();
		String password = user.getPassword();
		try {
			String sql = "UPDATE USERS SET EMAIL = ?, FNAME =?, LNAME =?, PASSWORD =? WHERE ID =?";
			this.jdbcTemplate.update(sql,email,fname,lname,password,Id);
		}catch(Exception ex) {
			System.out.print("Error: "+ ex.getMessage().toString());
		}
	}

	@Override
	public User findUserByEmail(String email) {
		List<User> user= null;
		try {
			String sql = "SELECT * FROM USERS WHERE EMAIL = ? LIMIT 1";
			return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ? FETCH FIRST 1 ROWS ONLY",BeanPropertyRowMapper.newInstance(User.class), email);
		}catch(Exception ex) {
			System.out.print(ex.getMessage().toString());
			return null;
		}
	}

}
