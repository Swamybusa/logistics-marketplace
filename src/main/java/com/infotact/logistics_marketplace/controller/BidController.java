package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.BidRequestDTO;
import com.infotact.logistics_marketplace.dto.BidResponseDTO;
import com.infotact.logistics_marketplace.service.BidService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bids")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping
    public BidResponseDTO createBid(
            @RequestBody BidRequestDTO bidRequestDTO) {

        return bidService.createBid(bidRequestDTO);
    }

    @GetMapping("/{id}")
    public BidResponseDTO getBidById(@PathVariable Long id) {

        return bidService.getBidById(id);
    }

    @GetMapping
    public List<BidResponseDTO> getAllBids() {

        return bidService.getAllBids();
    }

    @PutMapping("/{id}")
    public BidResponseDTO updateBid(
            @PathVariable Long id,
            @RequestBody BidRequestDTO bidRequestDTO) {

        return bidService.updateBid(id, bidRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable Long id) {

        bidService.deleteBid(id);
    }
}