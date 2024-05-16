package com.icesi.sarec.api;

import com.icesi.sarec.dto.RoleDTO;
import com.icesi.sarec.model.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/role")
public interface RoleApi {

    @PostMapping("/new")
    void newRole(@Valid @RequestBody RoleDTO roleDTO);

    @GetMapping("/get/all")
    List<Role> getAllRoles();

}
