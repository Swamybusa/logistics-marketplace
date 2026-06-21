package com.infotact.logistics_marketplace.dto;

import lombok.Data;

@Data
public class BidResponseDTO {
	private Long bidId;
	private Double amount;
	private Long shipmentId;
	private Long carrierId;

}
