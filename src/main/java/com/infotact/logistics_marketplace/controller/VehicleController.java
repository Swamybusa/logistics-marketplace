package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.VehicleRequestDTO;
import com.infotact.logistics_marketplace.dto.VehicleResponseDTO;
import com.infotact.logistics_marketplace.service.VehicleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public VehicleResponseDTO createVehicle(
            @Valid@RequestBody VehicleRequestDTO vehicleRequestDTO) {

        return vehicleService.createVehicle(vehicleRequestDTO);
    }

    @GetMapping("/{id}")
    public VehicleResponseDTO getVehicleById(@PathVariable Long id) {

        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    public List<VehicleResponseDTO> getAllVehicles() {

        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{id}")
    public VehicleResponseDTO updateVehicle(
           @Valid @PathVariable Long id,
            @RequestBody VehicleRequestDTO vehicleRequestDTO) {

        return vehicleService.updateVehicle(id, vehicleRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);
    }
}