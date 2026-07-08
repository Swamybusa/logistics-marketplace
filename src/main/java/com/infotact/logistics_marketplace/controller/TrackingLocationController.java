package com.infotact.logistics_marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.TrackingLocationRequestDTO;
import com.infotact.logistics_marketplace.dto.TrackingLocationResponseDTO;
import com.infotact.logistics_marketplace.service.TrackingLocationService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/tracking-locations")
@RequiredArgsConstructor
public class TrackingLocationController {


    private final TrackingLocationService trackingLocationService;



    @PostMapping
    public ResponseEntity<TrackingLocationResponseDTO> createLocation(
            @RequestBody TrackingLocationRequestDTO requestDTO) {


        return new ResponseEntity<>(
                trackingLocationService.createTrackingLocation(requestDTO),
                HttpStatus.CREATED
        );
    }



    @GetMapping("/latest/{shipmentId}")
    public ResponseEntity<TrackingLocationResponseDTO> getLatestLocation(
            @PathVariable Long shipmentId) {


        return ResponseEntity.ok(
                trackingLocationService.getLatestLocation(shipmentId)
        );
    }

}