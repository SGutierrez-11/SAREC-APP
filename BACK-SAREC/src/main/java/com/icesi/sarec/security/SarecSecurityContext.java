package com.icesi.sarec.security;


import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class SarecSecurityContext {

    public  String getCurrenUserId(){
        return ((JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getToken().getClaimAsString("icesiUserId");
    }

    public  String getCurrenUserRole(){
        return ((JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getToken().getClaimAsString("scope");
    }
}