package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Review;
import com.scm.repositery.ReviewRepo;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    
    public List<Review> getReviewsByBookId(Integer bookId) {
       return reviewRepo.findByBookId(bookId);
    //	return null;
    }

    @Override
    public List<Review> getReviewsByUserId(Integer userId) {
       return reviewRepo.findByUserId(userId);
    //	return null;
    }

    @Override
    public Review getReviewById(Integer reviewId) {
        Optional<Review> review = reviewRepo.findById(reviewId);
        return review.orElse(null);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Integer reviewId) {
        reviewRepo.deleteById(reviewId);
    }


	
}