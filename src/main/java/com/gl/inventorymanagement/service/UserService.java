package com.gl.inventorymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.User;
import com.gl.inventorymanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User authenticate(User user) {
		return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));

		return userRepository.save(user);
	}
	
}
