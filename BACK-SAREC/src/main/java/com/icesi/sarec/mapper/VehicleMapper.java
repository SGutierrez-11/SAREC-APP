package com.icesi.sarec.mapper;

import com.icesi.sarec.dto.VehicleDTO;
import com.icesi.sarec.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    Vehicle vehicleDTOToVehicle(VehicleDTO vehicleDTO);

}
