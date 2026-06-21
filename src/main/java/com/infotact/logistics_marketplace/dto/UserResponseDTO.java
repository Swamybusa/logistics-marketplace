package com.infotact.logistics_marketplace.dto;

import com.infotact.logistics_marketplace.enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private Role role;

}