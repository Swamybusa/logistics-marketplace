package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotact.logistics_marketplace.dto.LocationRequestDTO;
import com.infotact.logistics_marketplace.dto.LocationResponseDTO;
import com.infotact.logistics_marketplace.service.LocationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public LocationResponseDTO createLocation(
           @Valid @RequestBody LocationRequestDTO locationRequestDTO) {

        return locationService.createLocation(locationRequestDTO);
    }

    @GetMapping("/{id}")
    public LocationResponseDTO getLocationById(@PathVariable Long id) {

        return locationService.getLocationById(id);
    }

    @GetMapping
    public List<LocationResponseDTO> getAllLocations() {

        return locationService.getAllLocations();
    }

    @PutMapping("/{id}")
    public LocationResponseDTO updateLocation(
          @Valid  @PathVariable Long id,
            @RequestBody LocationRequestDTO locationRequestDTO) {

        return locationService.updateLocation(id, locationRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {

        locationService.deleteLocation(id);
    }
}