package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	 User findByEmail(String email);
	 
	 boolean existsByEmail(String email);
	 
	 

}
