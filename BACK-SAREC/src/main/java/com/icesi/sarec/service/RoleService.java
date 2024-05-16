package com.icesi.sarec.service;

import com.icesi.sarec.dto.RoleDTO;
import com.icesi.sarec.mapper.RoleMapper;
import com.icesi.sarec.model.Role;
import com.icesi.sarec.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public void newRole(RoleDTO roleDTO) {
        Role role = roleMapper.fromRoleDto(roleDTO);
        roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
