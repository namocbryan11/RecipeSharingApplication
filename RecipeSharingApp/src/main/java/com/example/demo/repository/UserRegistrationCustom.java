package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRegistrationCustom {
	public boolean registerUser(User user);
}
