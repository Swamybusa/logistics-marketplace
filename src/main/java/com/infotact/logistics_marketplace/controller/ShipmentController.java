package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.ShipmentRequestDTO;
import com.infotact.logistics_marketplace.dto.ShipmentResponseDTO;
import com.infotact.logistics_marketplace.service.ShipmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public ShipmentResponseDTO createShipment(
           @Valid @RequestBody ShipmentRequestDTO shipmentRequestDTO) {

        return shipmentService.createShipment(shipmentRequestDTO);
    }

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipmentById(@PathVariable Long id) {

        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentResponseDTO> getAllShipments(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return shipmentService.getAllShipments(
                page,
                size,
                sortBy,
                direction);
    }

    @PutMapping("/{id}")
    public ShipmentResponseDTO updateShipment(
          @Valid  @PathVariable Long id,
            @RequestBody ShipmentRequestDTO shipmentRequestDTO) {

        return shipmentService.updateShipment(id, shipmentRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {

        shipmentService.deleteShipment(id);
    }
}