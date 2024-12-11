package com.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.scm.repositery.UserRepo;

@SpringBootApplication
public class GkPublicationsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = 
				SpringApplication.run(GkPublicationsApplication.class, args);
		

		
	}

}
