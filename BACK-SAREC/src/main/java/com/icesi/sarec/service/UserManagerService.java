package com.icesi.sarec.service;

import com.icesi.sarec.model.SecurityUser;
import com.icesi.sarec.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManagerService implements UserDetailsService {
    private  final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("username not found: "+username));
    }
}