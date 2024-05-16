package com.icesi.sarec.dto;

import com.icesi.sarec.validation.annotation.ColombianNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;

    @ColombianNumber
    private String phoneNumber;

    private String password;

    @NotBlank
    @Email
    private String email;
    private RoleDTO role;
}