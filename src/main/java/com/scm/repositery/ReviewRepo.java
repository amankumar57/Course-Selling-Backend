package com.scm.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	// Find reviews by book ID
    List<Review> findByBookId(Integer bookId);

    // Find reviews by user ID
    List<Review> findByUserId(Integer userId);

}
