package com.infotact.logistics_marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotact.logistics_marketplace.config.JwtUtil;
import com.infotact.logistics_marketplace.dto.LoginRequestDTO;
import com.infotact.logistics_marketplace.dto.LoginResponseDTO;
import com.infotact.logistics_marketplace.dto.UserResponseDTO;
import com.infotact.logistics_marketplace.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );


        String token = jwtUtil.generateToken(
                request.getEmail()
        );


        UserResponseDTO user =
                userService.getUserByEmail(
                        request.getEmail()
                );


        LoginResponseDTO response =
                LoginResponseDTO.builder()
                        .token(token)
                        .message("Login successful")
                        .user(user)
                        .build();


        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );

    }

}