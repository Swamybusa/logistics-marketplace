package com.infotact.logistics_marketplace.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotact.logistics_marketplace.enums.ShipmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Double weight;

	@Column(nullable = false)
	private Double budget;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ShipmentStatus status;

	@ManyToOne
	@JoinColumn(name = "source_location_id")
	private Location sourceLocation;

	@ManyToOne
	@JoinColumn(name = "destination_location_id")
	private Location destinationLocation;

	@ManyToOne
	@JoinColumn(name = "shipper_id", nullable = false)
	private User shipper;

	@ManyToOne
	@JoinColumn(name = "assigned_carrier_id")
	private User assignedCarrier;

	@OneToMany(mappedBy = "shipment")
	@JsonIgnore
	@ToString.Exclude
	private List<Bid> bids;

}
