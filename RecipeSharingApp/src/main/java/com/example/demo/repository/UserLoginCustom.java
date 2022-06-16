package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.model.User;

@Repository
public interface UserLoginCustom {
	public List<User> getUserByEmailAndPassword(String email, String password);
}
