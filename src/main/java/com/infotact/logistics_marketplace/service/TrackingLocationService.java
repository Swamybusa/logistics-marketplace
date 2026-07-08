package com.infotact.logistics_marketplace.service;

import com.infotact.logistics_marketplace.dto.TrackingLocationRequestDTO;
import com.infotact.logistics_marketplace.dto.TrackingLocationResponseDTO;

public interface TrackingLocationService {

    TrackingLocationResponseDTO createTrackingLocation(
            TrackingLocationRequestDTO requestDTO
    );


    TrackingLocationResponseDTO getLatestLocation(
            Long shipmentId
    );

}