package com.infotact.logistics_marketplace.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationResponseDTO {

	private Long id;
	private String city;
	private String state;
	private String country;
	
    private Long shipmentId;
	private Double latitude; // ❗ ADD THIS
	private Double longitude; // ❗ ADD THIS


}