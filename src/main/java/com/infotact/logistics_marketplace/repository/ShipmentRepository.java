package com.infotact.logistics_marketplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.Shipment;
import com.infotact.logistics_marketplace.enums.ShipmentStatus;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
	Page<Shipment> findAll(Pageable pageable);
	
	Page<Shipment> findByStatus(ShipmentStatus status, Pageable pageable);
}
