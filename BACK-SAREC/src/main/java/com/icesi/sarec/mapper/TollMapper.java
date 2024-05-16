package com.icesi.sarec.mapper;

import com.icesi.sarec.dto.TollDTO;
import com.icesi.sarec.model.Toll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TollMapper {

    @Mapping(target = "uuid", ignore = true)
    Toll fromTollDto(TollDTO tollDTO);

}
