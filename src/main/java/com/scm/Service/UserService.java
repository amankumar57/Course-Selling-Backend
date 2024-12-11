package com.scm.Service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.scm.entity.User;
import com.scm.repositery.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 8;
    
    
    public String registerUser(String email) {
    	
    	  // Generate random password
    	String password = generateRandomPassword();
    	
    	 // Create and save the user
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Ideally, password should be encrypted
        userRepo.save(user);

        // Send the password via email
        sendPasswordEmail(email, password);

        return "Registration successful! Check your email for the password.";	
    }
    
    private String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
	
	
    private void sendPasswordEmail(String toEmail, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your Gk_Publication  Password");
        message.setText("Your password is: " + password);

        mailSender.send(message);
    }

    public boolean validateLogin(String email, String password) {
    	
        User user = userRepo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
    
    
    
    
}
