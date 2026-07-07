package com.infotact.logistics_marketplace.service;

import java.util.List;

import com.infotact.logistics_marketplace.dto.LocationRequestDTO;
import com.infotact.logistics_marketplace.dto.LocationResponseDTO;

public interface LocationService {

    LocationResponseDTO createLocation(LocationRequestDTO locationRequestDTO);

    LocationResponseDTO getLocationById(Long id);

    List<LocationResponseDTO> getAllLocations();

    LocationResponseDTO updateLocation(Long id, LocationRequestDTO locationRequestDTO);

    void deleteLocation(Long id);
    LocationResponseDTO getLatestLocation(Long shipmentId);

}