package com.scm.Service;

import java.util.List;

import com.scm.entity.Review;

public interface ReviewService {

    List<Review> getAllReviews();

    List<Review> getReviewsByBookId(Integer bookId);

    List<Review> getReviewsByUserId(Integer userId);

    Review getReviewById(Integer reviewId);

    Review createReview(Review review);

    Review updateReview(Review review);

    void deleteReview(Integer reviewId);
}