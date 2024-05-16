package com.icesi.sarec.controller;

import com.icesi.sarec.api.RoleApi;
import com.icesi.sarec.dto.RoleDTO;
import com.icesi.sarec.model.Role;
import com.icesi.sarec.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class RoleController implements RoleApi {
    private final RoleService roleService;

    @Override
    public void newRole(RoleDTO roleDTO) {
        roleService.newRole(roleDTO);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
