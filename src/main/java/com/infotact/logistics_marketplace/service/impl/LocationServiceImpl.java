package com.infotact.logistics_marketplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infotact.logistics_marketplace.dto.LocationRequestDTO;
import com.infotact.logistics_marketplace.dto.LocationResponseDTO;
import com.infotact.logistics_marketplace.entity.Location;
import com.infotact.logistics_marketplace.repository.LocationRepository;
import com.infotact.logistics_marketplace.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

   

    @Override
    public LocationResponseDTO createLocation(LocationRequestDTO locationRequestDTO) {

        Location location = Location.builder()
                .city(locationRequestDTO.getCity())
                .state(locationRequestDTO.getState())
                .country(locationRequestDTO.getCountry())
                .build();

        Location savedLocation = locationRepository.save(location);

        return LocationResponseDTO.builder()
                .id(savedLocation.getId())
                .city(savedLocation.getCity())
                .state(savedLocation.getState())
                .country(savedLocation.getCountry())
                .build();
    }

    @Override
    public LocationResponseDTO getLocationById(Long id) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));

        return LocationResponseDTO.builder()
                .id(location.getId())
                .city(location.getCity())
                .state(location.getState())
                .country(location.getCountry())
                .build();
    }

    @Override
    public List<LocationResponseDTO> getAllLocations() {

        return locationRepository.findAll()
                .stream()
                .map(location -> LocationResponseDTO.builder()
                        .id(location.getId())
                        .city(location.getCity())
                        .state(location.getState())
                        .country(location.getCountry())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public LocationResponseDTO updateLocation(Long id, LocationRequestDTO locationRequestDTO) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));

        location.setCity(locationRequestDTO.getCity());
        location.setState(locationRequestDTO.getState());
        location.setCountry(locationRequestDTO.getCountry());

        Location updatedLocation = locationRepository.save(location);

        return LocationResponseDTO.builder()
                .id(updatedLocation.getId())
                .city(updatedLocation.getCity())
                .state(updatedLocation.getState())
                .country(updatedLocation.getCountry())
                .build();
    }

    @Override
    public void deleteLocation(Long id) {

        locationRepository.deleteById(id);
    }
}