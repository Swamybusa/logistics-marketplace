package com.infotact.logistics_marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.TrackingLocation;

@Repository
public interface TrackingLocationRepository 
        extends JpaRepository<TrackingLocation, Long> {

    Optional<TrackingLocation> findTopByShipmentIdOrderByCreatedAtDesc(Long shipmentId);

}