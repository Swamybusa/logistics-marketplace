package com.infotact.logistics_marketplace.service.impl;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;
import com.infotact.logistics_marketplace.entity.*;
import com.infotact.logistics_marketplace.enums.*;
import com.infotact.logistics_marketplace.exception.ResourceNotFoundException;
import com.infotact.logistics_marketplace.repository.*;
import com.infotact.logistics_marketplace.service.ShipmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    // CREATE
    @Override
    public ShipmentResponseDTO createShipment(ShipmentRequestDTO dto) {

        Shipment shipment = new Shipment();

        shipment.setWeight(dto.getWeight());
        shipment.setBudget(dto.getBudget());
        shipment.setStatus(ShipmentStatus.BIDDING);

        shipment.setSourceLocation(locationRepository.findById(dto.getSourceLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Source not found")));

        shipment.setDestinationLocation(locationRepository.findById(dto.getDestinationLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found")));

        shipment.setShipper(userRepository.findById(dto.getShipperId())
                .orElseThrow(() -> new ResourceNotFoundException("Shipper not found")));

        return map(shipmentRepository.save(shipment));
    }

    // GET BY ID
    @Override
    public ShipmentResponseDTO getShipmentById(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        return map(shipment);
    }

    // GET ALL
    @Override
    public List<ShipmentResponseDTO> getAllShipments(
            ShipmentStatus status,
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Shipment> result = (status != null)
                ? shipmentRepository.findByStatus(status, pageable)
                : shipmentRepository.findAll(pageable);

        return result.getContent().stream().map(this::map).toList();
    }

    // UPDATE
    @Override
    public ShipmentResponseDTO updateShipment(Long id, ShipmentRequestDTO dto) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        shipment.setWeight(dto.getWeight());
        shipment.setBudget(dto.getBudget());

        return map(shipmentRepository.save(shipment));
    }

    // ASSIGN (IMPORTANT FIX)
    @Override
    public ShipmentResponseDTO assignShipment(Long shipmentId, Long carrierId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        if (shipment.getStatus() != ShipmentStatus.PENDING) {
            throw new IllegalStateException("Only PENDING shipments can be assigned");
        }

        User carrier = userRepository.findById(carrierId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // optional role check
        if (carrier.getRole() != Role.CARRIER) {
            throw new IllegalStateException("User is not a CARRIER");
        }

        shipment.setAssignedCarrier(carrier);
        shipment.setStatus(ShipmentStatus.AWAITING_PICKUP);

        return map(shipmentRepository.save(shipment));
    }

    // START
    @Override
    public ShipmentResponseDTO startShipment(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        if (shipment.getStatus() != ShipmentStatus.AWAITING_PICKUP) {
            throw new IllegalStateException("Shipment must be in AWAITING_PICKUP status");
        }

        shipment.setStatus(ShipmentStatus.IN_TRANSIT);

        return map(shipmentRepository.save(shipment));
    }

    // DELIVER
    @Override
    public ShipmentResponseDTO deliverShipment(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        if (shipment.getStatus() != ShipmentStatus.IN_TRANSIT) {
            throw new IllegalStateException("Shipment must be IN_TRANSIT first");
        }

        shipment.setStatus(ShipmentStatus.DELIVERED);

        return map(shipmentRepository.save(shipment));
    }
    @Override
    public List<ShipmentResponseDTO> getShipmentsByCarrier(Long carrierId) {

        return shipmentRepository.findByAssignedCarrierId(carrierId)
                .stream()
                .map(this::map)
                .toList();
    }
    // DELETE
    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    // MAPPER
    private ShipmentResponseDTO map(Shipment s) {

        return ShipmentResponseDTO.builder()

                .id(s.getId())

                .weight(s.getWeight())

                .budget(s.getBudget())

                .status(s.getStatus())


                .sourceLocationId(
                        s.getSourceLocation().getId()
                )

                .destinationLocationId(
                        s.getDestinationLocation().getId()
                )


                .sourceCity(
                        s.getSourceLocation().getCity()
                )

                .destinationCity(
                        s.getDestinationLocation().getCity()
                )


                .shipperId(
                        s.getShipper().getId()
                )


                .assignedCarrierId(
                        s.getAssignedCarrier() != null
                        ? s.getAssignedCarrier().getId()
                        : null
                )


                .build();
    }
    @Override
    public ShipmentResponseDTO cancelShipment(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        shipment.setStatus(ShipmentStatus.CANCELLED);

        return map(shipmentRepository.save(shipment));
    }
}