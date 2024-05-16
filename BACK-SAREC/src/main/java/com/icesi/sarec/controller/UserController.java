package com.icesi.sarec.controller;


import com.icesi.sarec.api.UserApi;
import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController implements UserApi {
    private final UserService userService;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userService.save(userDTO);
    }


    @Override
    public List<SarecUser> getUsers() {
        return userService.getUsers();
    }
}