package com.infotact.logistics_marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
