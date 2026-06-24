package com.infotact.logistics_marketplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;
import com.infotact.logistics_marketplace.entity.Location;
import com.infotact.logistics_marketplace.entity.Shipment;
import com.infotact.logistics_marketplace.entity.User;
import com.infotact.logistics_marketplace.exception.ResourceNotFoundException;
import com.infotact.logistics_marketplace.repository.LocationRepository;
import com.infotact.logistics_marketplace.repository.ShipmentRepository;
import com.infotact.logistics_marketplace.repository.UserRepository;
import com.infotact.logistics_marketplace.service.ShipmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Override
    public ShipmentResponseDTO createShipment(ShipmentRequestDTO shipmentRequestDTO) {

        Location sourceLocation = locationRepository.findById(
                shipmentRequestDTO.getSourceLocationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Source location not found"));

        Location destinationLocation = locationRepository.findById(
                shipmentRequestDTO.getDestinationLocationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination location not found"));

        User shipper = userRepository.findById(
                shipmentRequestDTO.getShipperId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found"));

        Shipment shipment = Shipment.builder()
                .weight(shipmentRequestDTO.getWeight())
                .budget(shipmentRequestDTO.getBudget())
                .status(shipmentRequestDTO.getStatus())
                .sourceLocation(sourceLocation)
                .destinationLocation(destinationLocation)
                .shipper(shipper)
                .build();

        Shipment savedShipment = shipmentRepository.save(shipment);

        return ShipmentResponseDTO.builder()
                .id(savedShipment.getId())
                .weight(savedShipment.getWeight())
                .budget(savedShipment.getBudget())
                .status(savedShipment.getStatus())
                .sourceLocationId(savedShipment.getSourceLocation().getId())
                .destinationLocationId(savedShipment.getDestinationLocation().getId())
                .shipperId(savedShipment.getShipper().getId())
                .build();
    }

    @Override
    public ShipmentResponseDTO getShipmentById(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Shipment not found with id: " + id));

        return ShipmentResponseDTO.builder()
                .id(shipment.getId())
                .weight(shipment.getWeight())
                .budget(shipment.getBudget())
                .status(shipment.getStatus())
                .sourceLocationId(shipment.getSourceLocation().getId())
                .destinationLocationId(shipment.getDestinationLocation().getId())
                .shipperId(shipment.getShipper().getId())
                .build();
    }

    @Override
    public List<ShipmentResponseDTO> getAllShipments() {

        return shipmentRepository.findAll()
                .stream()
                .map(shipment -> ShipmentResponseDTO.builder()
                        .id(shipment.getId())
                        .weight(shipment.getWeight())
                        .budget(shipment.getBudget())
                        .status(shipment.getStatus())
                        .sourceLocationId(shipment.getSourceLocation().getId())
                        .destinationLocationId(shipment.getDestinationLocation().getId())
                        .shipperId(shipment.getShipper().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ShipmentResponseDTO updateShipment(Long id,
            ShipmentRequestDTO shipmentRequestDTO) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Shipment not found with id: " + id));

        Location sourceLocation = locationRepository.findById(
                shipmentRequestDTO.getSourceLocationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Source location not found"));

        Location destinationLocation = locationRepository.findById(
                shipmentRequestDTO.getDestinationLocationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination location not found"));

        User shipper = userRepository.findById(
                shipmentRequestDTO.getShipperId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found"));

        shipment.setWeight(shipmentRequestDTO.getWeight());
        shipment.setBudget(shipmentRequestDTO.getBudget());
        shipment.setStatus(shipmentRequestDTO.getStatus());
        shipment.setSourceLocation(sourceLocation);
        shipment.setDestinationLocation(destinationLocation);
        shipment.setShipper(shipper);

        Shipment updatedShipment = shipmentRepository.save(shipment);

        return ShipmentResponseDTO.builder()
                .id(updatedShipment.getId())
                .weight(updatedShipment.getWeight())
                .budget(updatedShipment.getBudget())
                .status(updatedShipment.getStatus())
                .sourceLocationId(updatedShipment.getSourceLocation().getId())
                .destinationLocationId(updatedShipment.getDestinationLocation().getId())
                .shipperId(updatedShipment.getShipper().getId())
                .build();
    }

    @Override
    public void deleteShipment(Long id) {

        shipmentRepository.deleteById(id);
    }
}