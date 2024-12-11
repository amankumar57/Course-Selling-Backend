package com.scm.repositery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Cart;
import com.scm.entity.User;

public interface CartRepo extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findByUser(User user);
    List<Cart> findAllByUser(User user);
}
