package com.icesi.sarec.mapper;



import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.model.SarecUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    SarecUser fromUserDto(UserDTO userDTO);
    UserDTO fromUser(SarecUser sarecUser);
}