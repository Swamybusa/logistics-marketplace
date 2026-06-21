package com.infotact.logistics_marketplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.VehicleRequestDTO;
import com.infotact.logistics_marketplace.dto.VehicleResponseDTO;
import com.infotact.logistics_marketplace.entity.User;
import com.infotact.logistics_marketplace.entity.Vehicle;
import com.infotact.logistics_marketplace.repository.UserRepository;
import com.infotact.logistics_marketplace.repository.VehicleRepository;
import com.infotact.logistics_marketplace.service.VehicleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    @Override
    public VehicleResponseDTO createVehicle(VehicleRequestDTO vehicleRequestDTO) {

        User carrier = userRepository.findById(vehicleRequestDTO.getCarrierId())
                .orElseThrow(() -> new RuntimeException(
                        "User not found with id: " + vehicleRequestDTO.getCarrierId()));

        Vehicle vehicle = Vehicle.builder()
                .vehicleNumber(vehicleRequestDTO.getVehicleNumber())
                .vehicleType(vehicleRequestDTO.getVehicleType())
                .capacity(vehicleRequestDTO.getCapacity())
                .carrier(carrier)
                .build();

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return VehicleResponseDTO.builder()
                .id(savedVehicle.getId())
                .vehicleNumber(savedVehicle.getVehicleNumber())
                .vehicleType(savedVehicle.getVehicleType())
                .capacity(savedVehicle.getCapacity())
                .carrierId(savedVehicle.getCarrier().getId())
                .build();
    }

    @Override
    public VehicleResponseDTO getVehicleById(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        return VehicleResponseDTO.builder()
                .id(vehicle.getId())
                .vehicleNumber(vehicle.getVehicleNumber())
                .vehicleType(vehicle.getVehicleType())
                .capacity(vehicle.getCapacity())
                .carrierId(vehicle.getCarrier().getId())
                .build();
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {

        return vehicleRepository.findAll()
                .stream()
                .map(vehicle -> VehicleResponseDTO.builder()
                        .id(vehicle.getId())
                        .vehicleNumber(vehicle.getVehicleNumber())
                        .vehicleType(vehicle.getVehicleType())
                        .capacity(vehicle.getCapacity())
                        .carrierId(vehicle.getCarrier().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO vehicleRequestDTO) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        User carrier = userRepository.findById(vehicleRequestDTO.getCarrierId())
                .orElseThrow(() -> new RuntimeException(
                        "User not found with id: " + vehicleRequestDTO.getCarrierId()));

        vehicle.setVehicleNumber(vehicleRequestDTO.getVehicleNumber());
        vehicle.setVehicleType(vehicleRequestDTO.getVehicleType());
        vehicle.setCapacity(vehicleRequestDTO.getCapacity());
        vehicle.setCarrier(carrier);

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return VehicleResponseDTO.builder()
                .id(updatedVehicle.getId())
                .vehicleNumber(updatedVehicle.getVehicleNumber())
                .vehicleType(updatedVehicle.getVehicleType())
                .capacity(updatedVehicle.getCapacity())
                .carrierId(updatedVehicle.getCarrier().getId())
                .build();
    }

    @Override
    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);
    }
}