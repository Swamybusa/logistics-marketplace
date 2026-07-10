package com.infotact.logistics_marketplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.infotact.logistics_marketplace.entity.Shipment;
import com.infotact.logistics_marketplace.enums.ShipmentStatus;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Page<Shipment> findByStatus(ShipmentStatus status, Pageable pageable);

    List<Shipment> findByAssignedCarrierId(Long carrierId);
}