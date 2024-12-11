package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Register a new user by email
    @PostMapping("/register")
    public String register(@RequestParam String email) {
        return userService.registerUser(email);
    }

    // Login with email and password
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean isValid = userService.validateLogin(email, password);
        return isValid ? "Login successful!" : "Invalid email or password!";
    }
    
    // reaset Password
    
}


