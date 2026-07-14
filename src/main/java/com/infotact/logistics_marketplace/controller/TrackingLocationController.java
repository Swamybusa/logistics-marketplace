package com.infotact.logistics_marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    private final SimpMessagingTemplate messagingTemplate;



    @PostMapping
    public ResponseEntity<TrackingLocationResponseDTO> createLocation(
            @RequestBody TrackingLocationRequestDTO requestDTO) {


        TrackingLocationResponseDTO response =
                trackingLocationService.createTrackingLocation(requestDTO);


        // send live update
        messagingTemplate.convertAndSend(
                "/topic/shipments/" + requestDTO.getShipmentId(),
                response
        );


        return new ResponseEntity<>(
                response,
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