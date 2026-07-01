package com.infotact.logistics_marketplace.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.infotact.logistics_marketplace.dto.LocationMessageDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LocationWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/location")
    public void updateLocation(LocationMessageDTO location) {

        messagingTemplate.convertAndSend(
                "/topic/shipments/" + location.getShipmentId(),
                location
        );
    }
}