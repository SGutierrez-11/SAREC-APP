package com.icesi.sarec.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateDTOResponse {

    private UserDTO user;
}
