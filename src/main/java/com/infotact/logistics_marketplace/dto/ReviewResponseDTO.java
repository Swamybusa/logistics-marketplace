package com.infotact.logistics_marketplace.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {

    private Long id;
    private Integer rating;
    private String comment;
    private Long reviewerId;
    private Long reviewedUserId;

}