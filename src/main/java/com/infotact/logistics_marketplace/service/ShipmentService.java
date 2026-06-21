package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;

public interface ShipmentService {

    ShipmentResponseDTO createShipment(ShipmentRequestDTO shipmentRequestDTO);

    ShipmentResponseDTO getShipmentById(Long id);

    List<ShipmentResponseDTO> getAllShipments();

    ShipmentResponseDTO updateShipment(Long id, ShipmentRequestDTO shipmentRequestDTO);

    void deleteShipment(Long id);

}