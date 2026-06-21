package com.infotact.logistics_marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BidRequestDTO {
	private Double amount;
	private Long shipmentId;
	private Long carrierId;

}
