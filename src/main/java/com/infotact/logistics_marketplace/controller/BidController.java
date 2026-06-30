package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotact.logistics_marketplace.dto.BidRequestDTO;
import com.infotact.logistics_marketplace.dto.BidResponseDTO;
import com.infotact.logistics_marketplace.service.BidService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bids")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping
    public BidResponseDTO createBid(
          @Valid  @RequestBody BidRequestDTO bidRequestDTO) {

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
           @Valid @PathVariable Long id,
            @RequestBody BidRequestDTO bidRequestDTO) {

        return bidService.updateBid(id, bidRequestDTO);
    }
    @PutMapping("/{bidId}/accept")
    public BidResponseDTO acceptBid(@PathVariable Long bidId) {
        return bidService.acceptBid(bidId);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable Long id) {

        bidService.deleteBid(id);
    }
}