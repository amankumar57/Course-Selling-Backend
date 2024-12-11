package com.scm.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer>{
	
	// Find wishlist items by user ID
    List<Wishlist> findByUserId(Long userId);

    // Optionally, find wishlist items by book ID
    List<Wishlist> findByBookId(Long bookId);

}
