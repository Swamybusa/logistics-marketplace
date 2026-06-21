package com.infotact.logistics_marketplace.dto;

import lombok.Data;

@Data
public class BidRequestDTO {
	private Double amount;
	private Long shipmentId;
	private Long carrierId;

}
