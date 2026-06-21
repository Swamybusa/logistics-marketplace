package com.infotact.logistics_marketplace.dto;

import com.infotact.logistics_marketplace.enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    private String fullName;
    private String email;
    private String password;
    private Role role;

}