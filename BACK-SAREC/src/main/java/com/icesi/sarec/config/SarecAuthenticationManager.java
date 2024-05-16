package com.icesi.sarec.config;

import com.icesi.sarec.model.SecurityUser;
import com.icesi.sarec.security.CustomAuthentication;
import com.icesi.sarec.service.UserManagerService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SarecAuthenticationManager extends DaoAuthenticationProvider {

    public SarecAuthenticationManager(UserManagerService userManagerService, PasswordEncoder passwordEncoder) {
        this.setUserDetailsService(userManagerService);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    public Authentication createSuccessAuthentication(Object principal , Authentication authentication, UserDetails user){
        UsernamePasswordAuthenticationToken successAuthentication =
                (UsernamePasswordAuthenticationToken) super.createSuccessAuthentication(principal, authentication, user);
        SecurityUser securityUser = (SecurityUser) user;
        return new CustomAuthentication(successAuthentication,securityUser.getSarecUser().getId().toString());

    }
}