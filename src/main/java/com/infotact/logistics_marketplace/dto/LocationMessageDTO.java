package com.infotact.logistics_marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationMessageDTO {

    private Long shipmentId;
    private Double latitude;
    private Double longitude;
}