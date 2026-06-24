package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.ReviewRequestDTO;
import com.infotact.logistics_marketplace.dto.ReviewResponseDTO;
import com.infotact.logistics_marketplace.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponseDTO createReview(
           @Valid @RequestBody ReviewRequestDTO reviewRequestDTO) {

        return reviewService.createReview(reviewRequestDTO);
    }

    @GetMapping("/{id}")
    public ReviewResponseDTO getReviewById(@PathVariable Long id) {

        return reviewService.getReviewById(id);
    }

    @GetMapping
    public List<ReviewResponseDTO> getAllReviews() {

        return reviewService.getAllReviews();
    }

    @PutMapping("/{id}")
    public ReviewResponseDTO updateReview(
           @Valid @PathVariable Long id,
            @RequestBody ReviewRequestDTO reviewRequestDTO) {

        return reviewService.updateReview(id, reviewRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);
    }
}