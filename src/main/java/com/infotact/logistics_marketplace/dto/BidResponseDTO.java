package com.infotact.logistics_marketplace.dto;

import com.infotact.logistics_marketplace.enums.BidStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BidResponseDTO {
	private Long id;
	private Double amount;
	private Long shipmentId;
	private Long carrierId;
	private BidStatus status;

}
