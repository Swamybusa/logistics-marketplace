package com.infotact.logistics_marketplace.dto;

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
public class BidRequestDTO {
	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than 0")
	private Double amount;

	@NotNull(message = "Shipment ID is required")
	private Long shipmentId;

	@NotNull(message = "Carrier ID is required")
	private Long carrierId;

}
