package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.*;
import com.infotact.logistics_marketplace.enums.ShipmentStatus;
import com.infotact.logistics_marketplace.service.ShipmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public ShipmentResponseDTO createShipment(@RequestBody ShipmentRequestDTO dto) {
        return shipmentService.createShipment(dto);
    }

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipment(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentResponseDTO> getAllShipments(
            @RequestParam(required = false) ShipmentStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return shipmentService.getAllShipments(status, page, size, sortBy, direction);
    }

    @PutMapping("/{id}/assign")
    public ShipmentResponseDTO assignShipment(
            @PathVariable Long id,
            @RequestParam Long carrierId) {
        return shipmentService.assignShipment(id, carrierId);
    }

    @PutMapping("/{id}/start")
    public ShipmentResponseDTO startShipment(@PathVariable Long id) {
        return shipmentService.startShipment(id);
    }

    @PutMapping("/{id}/deliver")
    public ShipmentResponseDTO deliverShipment(@PathVariable Long id) {
        return shipmentService.deliverShipment(id);
    }

    @PutMapping("/{id}")
    public ShipmentResponseDTO updateShipment(
            @PathVariable Long id,
            @RequestBody ShipmentRequestDTO dto) {
        return shipmentService.updateShipment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}