package com.infotact.logistics_marketplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.ReviewRequestDTO;
import com.infotact.logistics_marketplace.dto.ReviewResponseDTO;
import com.infotact.logistics_marketplace.entity.Review;
import com.infotact.logistics_marketplace.entity.User;
import com.infotact.logistics_marketplace.repository.ReviewRepository;
import com.infotact.logistics_marketplace.repository.UserRepository;
import com.infotact.logistics_marketplace.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {

        User reviewer = userRepository.findById(reviewRequestDTO.getReviewerId())
                .orElseThrow(() -> new RuntimeException(
                        "Reviewer not found with id: " + reviewRequestDTO.getReviewerId()));

        User reviewedUser = userRepository.findById(reviewRequestDTO.getReviewedUserId())
                .orElseThrow(() -> new RuntimeException(
                        "Reviewed user not found with id: " + reviewRequestDTO.getReviewedUserId()));

        Review review = Review.builder()
                .rating(reviewRequestDTO.getRating())
                .comment(reviewRequestDTO.getComment())
                .reviewer(reviewer)
                .reviewedUser(reviewedUser)
                .build();

        Review savedReview = reviewRepository.save(review);

        return ReviewResponseDTO.builder()
                .id(savedReview.getId())
                .rating(savedReview.getRating())
                .comment(savedReview.getComment())
                .reviewerId(savedReview.getReviewer().getId())
                .reviewedUserId(savedReview.getReviewedUser().getId())
                .build();
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .reviewerId(review.getReviewer().getId())
                .reviewedUserId(review.getReviewedUser().getId())
                .build();
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {

        return reviewRepository.findAll()
                .stream()
                .map(review -> ReviewResponseDTO.builder()
                        .id(review.getId())
                        .rating(review.getRating())
                        .comment(review.getComment())
                        .reviewerId(review.getReviewer().getId())
                        .reviewedUserId(review.getReviewedUser().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO reviewRequestDTO) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        User reviewer = userRepository.findById(reviewRequestDTO.getReviewerId())
                .orElseThrow(() -> new RuntimeException(
                        "Reviewer not found with id: " + reviewRequestDTO.getReviewerId()));

        User reviewedUser = userRepository.findById(reviewRequestDTO.getReviewedUserId())
                .orElseThrow(() -> new RuntimeException(
                        "Reviewed user not found with id: " + reviewRequestDTO.getReviewedUserId()));

        review.setRating(reviewRequestDTO.getRating());
        review.setComment(reviewRequestDTO.getComment());
        review.setReviewer(reviewer);
        review.setReviewedUser(reviewedUser);

        Review updatedReview = reviewRepository.save(review);

        return ReviewResponseDTO.builder()
                .id(updatedReview.getId())
                .rating(updatedReview.getRating())
                .comment(updatedReview.getComment())
                .reviewerId(updatedReview.getReviewer().getId())
                .reviewedUserId(updatedReview.getReviewedUser().getId())
                .build();
    }

    @Override
    public void deleteReview(Long id) {

        reviewRepository.deleteById(id);
    }
}