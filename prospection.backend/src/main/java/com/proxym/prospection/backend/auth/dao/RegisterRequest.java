package com.proxym.prospection.backend.auth.dao;

import com.proxym.prospection.backend.features.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String joiningDate;
    private Role role;
    private String departments;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
}
