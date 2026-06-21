package com.infotact.logistics_marketplace.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRequestDTO {

    private String vehicleNumber;
    private String vehicleType;
    private Double capacity;
    private Long carrierId;

}