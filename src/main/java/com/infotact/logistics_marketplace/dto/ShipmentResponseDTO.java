package com.infotact.logistics_marketplace.dto;

import com.infotact.logistics_marketplace.enums.ShipmentStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentResponseDTO {

	private Long id;
	private Double weight;
	private Double budget;
	private Double acceptedBidAmount;
	
	private ShipmentStatus status;
	
	private Long sourceLocationId;
	private Long destinationLocationId;
	
	private String sourceCity;
	private String destinationCity;
	
	private Long shipperId;
	private Long assignedCarrierId;


	

}