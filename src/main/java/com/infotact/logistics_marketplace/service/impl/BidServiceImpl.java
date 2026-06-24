package com.infotact.logistics_marketplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.BidRequestDTO;
import com.infotact.logistics_marketplace.dto.BidResponseDTO;
import com.infotact.logistics_marketplace.entity.Bid;
import com.infotact.logistics_marketplace.entity.Shipment;
import com.infotact.logistics_marketplace.entity.User;
import com.infotact.logistics_marketplace.exception.ResourceNotFoundException;
import com.infotact.logistics_marketplace.repository.BidRepository;
import com.infotact.logistics_marketplace.repository.ShipmentRepository;
import com.infotact.logistics_marketplace.repository.UserRepository;
import com.infotact.logistics_marketplace.service.BidService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final ShipmentRepository shipmentRepository;
    private final UserRepository userRepository;

    @Override
    public BidResponseDTO createBid(BidRequestDTO bidRequestDTO) {

        Shipment shipment = shipmentRepository.findById(bidRequestDTO.getShipmentId())
                .orElseThrow(() -> new RuntimeException(
                        "Shipment not found with id: " + bidRequestDTO.getShipmentId()));

        User carrier = userRepository.findById(bidRequestDTO.getCarrierId())
                .orElseThrow(() -> new RuntimeException(
                        "User not found with id: " + bidRequestDTO.getCarrierId()));

        Bid bid = Bid.builder()
                .amount(bidRequestDTO.getAmount())
                .shipment(shipment)
                .carrier(carrier)
                .build();

        Bid savedBid = bidRepository.save(bid);

        return BidResponseDTO.builder()
                .id(savedBid.getId())
                .amount(savedBid.getAmount())
                .shipmentId(savedBid.getShipment().getId())
                .carrierId(savedBid.getCarrier().getId())
                .build();
    }

    @Override
    public BidResponseDTO getBidById(Long id) {

        Bid bid = bidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Bid not found with id: " + id));

        return BidResponseDTO.builder()
                .id(bid.getId())
                .amount(bid.getAmount())
                .shipmentId(bid.getShipment().getId())
                .carrierId(bid.getCarrier().getId())
                .build();
    }

    @Override
    public List<BidResponseDTO> getAllBids() {

        return bidRepository.findAll()
                .stream()
                .map(bid -> BidResponseDTO.builder()
                        .id(bid.getId())
                        .amount(bid.getAmount())
                        .shipmentId(bid.getShipment().getId())
                        .carrierId(bid.getCarrier().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BidResponseDTO updateBid(Long id, BidRequestDTO bidRequestDTO) {

        Bid bid = bidRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Bid not found with id: " + id));

        Shipment shipment = shipmentRepository.findById(bidRequestDTO.getShipmentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Shipment not found with id: " + bidRequestDTO.getShipmentId()));

        User carrier = userRepository.findById(bidRequestDTO.getCarrierId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + bidRequestDTO.getCarrierId()));

        bid.setAmount(bidRequestDTO.getAmount());
        bid.setShipment(shipment);
        bid.setCarrier(carrier);

        Bid updatedBid = bidRepository.save(bid);

        return BidResponseDTO.builder()
                .id(updatedBid.getId())
                .amount(updatedBid.getAmount())
                .shipmentId(updatedBid.getShipment().getId())
                .carrierId(updatedBid.getCarrier().getId())
                .build();
    }

    @Override
    public void deleteBid(Long id) {

        bidRepository.deleteById(id);
    }
}