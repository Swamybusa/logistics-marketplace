package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.ReviewRequestDTO;
import com.infotact.logistics_marketplace.dto.ReviewResponseDTO;

public interface ReviewService {

    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO);

    ReviewResponseDTO getReviewById(Long id);

    List<ReviewResponseDTO> getAllReviews();

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO reviewRequestDTO);

    void deleteReview(Long id);

}