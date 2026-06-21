package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;
import com.infotact.logistics_marketplace.service.ShipmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public ShipmentResponseDTO createShipment(
            @RequestBody ShipmentRequestDTO shipmentRequestDTO) {

        return shipmentService.createShipment(shipmentRequestDTO);
    }

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipmentById(@PathVariable Long id) {

        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentResponseDTO> getAllShipments() {

        return shipmentService.getAllShipments();
    }

    @PutMapping("/{id}")
    public ShipmentResponseDTO updateShipment(
            @PathVariable Long id,
            @RequestBody ShipmentRequestDTO shipmentRequestDTO) {

        return shipmentService.updateShipment(id, shipmentRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {

        shipmentService.deleteShipment(id);
    }
}