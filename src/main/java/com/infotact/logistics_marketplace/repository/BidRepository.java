package com.infotact.logistics_marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
	List<Bid> findByShipment_Id(Long shipmentId);}
