package com.icesi.sarec.api;

import com.icesi.sarec.dto.JwtResponse;
import com.icesi.sarec.dto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@RequestMapping("/auth")
public interface AuthApi {
    @PostMapping("/login")
    JwtResponse token(@Valid @RequestBody LoginDto loginDto);
}