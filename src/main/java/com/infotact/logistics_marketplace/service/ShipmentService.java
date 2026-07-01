package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;
import com.infotact.logistics_marketplace.enums.ShipmentStatus;

public interface ShipmentService {

    ShipmentResponseDTO createShipment(ShipmentRequestDTO dto);

    ShipmentResponseDTO getShipmentById(Long id);

    List<ShipmentResponseDTO> getAllShipments(
            ShipmentStatus status,
            int page,
            int size,
            String sortBy,
            String direction);

    ShipmentResponseDTO updateShipment(Long id, ShipmentRequestDTO dto);

    ShipmentResponseDTO assignShipment(Long shipmentId, Long carrierId);

    ShipmentResponseDTO startShipment(Long shipmentId);

    ShipmentResponseDTO deliverShipment(Long shipmentId);

    void deleteShipment(Long id);
}