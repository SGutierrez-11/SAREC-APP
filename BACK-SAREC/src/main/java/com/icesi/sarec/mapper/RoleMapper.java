package com.icesi.sarec.mapper;

import com.icesi.sarec.dto.RoleDTO;
import com.icesi.sarec.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromRoleDto(RoleDTO role);

}
