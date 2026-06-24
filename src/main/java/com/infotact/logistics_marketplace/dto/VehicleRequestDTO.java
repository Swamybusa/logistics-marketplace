package com.infotact.logistics_marketplace.dto;

import jakarta.validation.constraints.NotBlank;
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
public class VehicleRequestDTO {
	@NotBlank(message = "Vehicle number is required")
	private String vehicleNumber;

	@NotBlank(message = "Vehicle type is required")
	private String vehicleType;

	@NotNull(message = "Capacity is required")
	@Positive(message = "Capacity must be greater than 0")
	private Double capacity;

	@NotNull(message = "Carrier ID is required")
	private Long carrierId;
    

}