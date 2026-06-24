package com.infotact.logistics_marketplace.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {
	@NotNull(message = "Rating is required")
	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating must not exceed 5")
	private Integer rating;

	private String comment;

	@NotNull(message = "Reviewer ID is required")
	private Long reviewerId;

	@NotNull(message = "Reviewed User ID is required")
	private Long reviewedUserId;
   

}