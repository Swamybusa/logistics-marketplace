package com.infotact.logistics_marketplace.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingLocationRequestDTO {

    private Long shipmentId;

    private Double latitude;

    private Double longitude;

    private String city;

    private String state;

    private String country;

}