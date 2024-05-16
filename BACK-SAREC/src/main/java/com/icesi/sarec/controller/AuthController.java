package com.icesi.sarec.controller;


import com.icesi.sarec.api.AuthApi;
import com.icesi.sarec.dto.JwtResponse;
import com.icesi.sarec.dto.LoginDto;
import com.icesi.sarec.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController implements AuthApi {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponse token(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginDto.getUserName(),loginDto.getPassword()));
        return tokenService.generateToken(authentication);
    }
}