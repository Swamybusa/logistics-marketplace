package com.infotact.logistics_marketplace.service.impl;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.TrackingLocationRequestDTO;
import com.infotact.logistics_marketplace.dto.TrackingLocationResponseDTO;
import com.infotact.logistics_marketplace.entity.TrackingLocation;
import com.infotact.logistics_marketplace.exception.ResourceNotFoundException;
import com.infotact.logistics_marketplace.repository.TrackingLocationRepository;
import com.infotact.logistics_marketplace.service.TrackingLocationService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TrackingLocationServiceImpl 
        implements TrackingLocationService {


    private final TrackingLocationRepository repository;



    @Override
    public TrackingLocationResponseDTO createTrackingLocation(
            TrackingLocationRequestDTO requestDTO) {


        TrackingLocation location = TrackingLocation.builder()
                .shipmentId(requestDTO.getShipmentId())
                .latitude(requestDTO.getLatitude())
                .longitude(requestDTO.getLongitude())
                .city(requestDTO.getCity())
                .state(requestDTO.getState())
                .country(requestDTO.getCountry())
                .build();


        TrackingLocation saved = repository.save(location);


        return mapToDTO(saved);
    }



    @Override
    public TrackingLocationResponseDTO getLatestLocation(
            Long shipmentId) {


        TrackingLocation location =
                repository.findTopByShipmentIdOrderByCreatedAtDesc(shipmentId)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Location not found for shipment id: "
                        + shipmentId
                    ));


        return mapToDTO(location);
    }



    private TrackingLocationResponseDTO mapToDTO(
            TrackingLocation location) {


        return TrackingLocationResponseDTO.builder()
                .id(location.getId())
                .shipmentId(location.getShipmentId())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .city(location.getCity())
                .state(location.getState())
                .country(location.getCountry())
                .createdAt(location.getCreatedAt())
                .build();
    }

}