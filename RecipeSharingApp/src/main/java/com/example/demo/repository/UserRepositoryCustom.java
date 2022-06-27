package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepositoryCustom {
	public void editUserById(User user, Long Id);
	public User findUserByEmail(String email);
}
