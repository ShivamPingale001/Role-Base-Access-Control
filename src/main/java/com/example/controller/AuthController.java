package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.repository.UserRepository;
import com.example.entity.User;
import com.example.config.JwtUtil;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private  UserRepository userRepository;
	
	@PostMapping("/register")
public User register(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {

	    User existingUser = userRepository.findByEmail(user.getEmail()).orElse(null);

	    if (existingUser == null) {
	        return "User not found";
	    }

	    if (!existingUser.getPassword().equals(user.getPassword())) {
	        return "Invalid password";
	    }

	    return JwtUtil.generateToken(existingUser.getEmail(), existingUser.getRole().name());
	}
}

