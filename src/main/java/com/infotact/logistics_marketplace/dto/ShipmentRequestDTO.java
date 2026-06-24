package com.infotact.logistics_marketplace.dto;

import com.infotact.logistics_marketplace.enums.ShipmentStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentRequestDTO {

	@NotNull(message = "Weight is required")
	@Positive(message = "Weight must be greater than 0")
	private Double weight;

	@NotNull(message = "Budget is required")
	@Positive(message = "Budget must be greater than 0")
	private Double budget;

	@NotNull(message = "Status is required")
	private ShipmentStatus status;

	@NotNull(message = "Source Location is required")
	private Long sourceLocationId;

	@NotNull(message = "Destination Location is required")
	private Long destinationLocationId;

	@NotNull(message = "Shipper ID is required")
	private Long shipperId;

}