package com.icesi.sarec.api;

import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.model.SarecUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
public interface UserApi {
    @PostMapping
    UserDTO createUser(@Valid @RequestBody UserDTO userDTO);

    @GetMapping
    List<SarecUser> getUsers();

}
