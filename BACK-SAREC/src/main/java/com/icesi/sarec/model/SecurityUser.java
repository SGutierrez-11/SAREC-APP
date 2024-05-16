package com.icesi.sarec.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
    private final SarecUser sarecUser;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(sarecUser).map(SarecUser::getRole).map(Role::getName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sarecUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sarecUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public SarecUser getSarecUser(){
        return sarecUser;
    }


}