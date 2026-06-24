package com.infotact.logistics_marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infotact.logistics_marketplace.dto.UserRequestDTO;
import com.infotact.logistics_marketplace.dto.UserResponseDTO;
import com.infotact.logistics_marketplace.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDTO createUser(
            @Valid @RequestBody UserRequestDTO userRequestDTO) {

        return userService.createUser(userRequestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
           @Valid @PathVariable Long id,
            @RequestBody UserRequestDTO userRequestDTO) {

        return userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }
}