package com.infotact.logistics_marketplace.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingLocationResponseDTO {

    private Long id;

    private Long shipmentId;

    private Double latitude;

    private Double longitude;

    private String city;

    private String state;

    private String country;

    private LocalDateTime createdAt;

}