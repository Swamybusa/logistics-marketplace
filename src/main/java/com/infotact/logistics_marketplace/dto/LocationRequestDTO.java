package com.infotact.logistics_marketplace.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationRequestDTO {

    private String city;
    private String state;
    private String country;

}