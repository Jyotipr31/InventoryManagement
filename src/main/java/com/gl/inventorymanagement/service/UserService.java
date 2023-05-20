package com.gl.inventorymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.User;
import com.gl.inventorymanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	   @Autowired
	    private PasswordEncoder passwordEncoder;


	public User authenticate(User user) {
		return userRepository.findUserByUsernameAndPassword(user.getName(), user.getPassword());
	}

	public User registerUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}
	
}
