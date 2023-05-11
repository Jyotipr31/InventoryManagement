package com.gl.inventorymanagement.service;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.Admin;
import com.gl.inventorymanagement.repository.UserRepository;

//@Service
//public class UserService {
//
//	@Autowired
//	UserRepository userRepository;
//	
////	   @Autowired
////	    private PasswordEncoder passwordEncoder;
//
////
////	public User authenticate(User user) {
////		return userRepository.findUserByUsernameAndPassword(user.getName(), user.getPassword());
////	}
//
//	public User registerUser(String username, String) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		user.setPassword(encoder.encode(user.getPassword()));
//
//		return userRepository.save(user);
//	}
//	
//}

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public Admin authenticate(String name, String password) {
		return userRepository.findUserByUsernameAndPassword(name, password);
	}

	public Admin registerAdmin(Admin admin) {
		String password=  passwordEncoder.encode(admin.getPassword());
		admin.setPassword(password);
		return userRepository.save(admin);
	}
	
}
