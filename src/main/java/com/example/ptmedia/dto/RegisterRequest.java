package com.example.ptmedia.dto;

import com.example.ptmedia.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
     private String email;
    private String password;
    private Role role;
}
