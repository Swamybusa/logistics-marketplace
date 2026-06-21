package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.VehicleRequestDTO;
import com.infotact.logistics_marketplace.dto.VehicleResponseDTO;

public interface VehicleService {

    VehicleResponseDTO createVehicle(VehicleRequestDTO vehicleRequestDTO);

    VehicleResponseDTO getVehicleById(Long id);

    List<VehicleResponseDTO> getAllVehicles();

    VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO vehicleRequestDTO);

    void deleteVehicle(Long id);

}