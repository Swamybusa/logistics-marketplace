package com.infotact.logistics_marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
