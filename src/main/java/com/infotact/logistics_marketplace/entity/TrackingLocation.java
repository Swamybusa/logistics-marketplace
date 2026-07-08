package com.infotact.logistics_marketplace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tracking_locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Long shipmentId;


    @Column(nullable = false)
    private Double latitude;


    @Column(nullable = false)
    private Double longitude;


    private String city;

    private String state;

    private String country;


    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}