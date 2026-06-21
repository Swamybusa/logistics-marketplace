package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.BidRequestDTO;
import com.infotact.logistics_marketplace.dto.BidResponseDTO;

public interface BidService {

    BidResponseDTO createBid(BidRequestDTO bidRequestDTO);

    BidResponseDTO getBidById(Long id);

    List<BidResponseDTO> getAllBids();

    BidResponseDTO updateBid(Long id, BidRequestDTO bidRequestDTO);

    void deleteBid(Long id);

}