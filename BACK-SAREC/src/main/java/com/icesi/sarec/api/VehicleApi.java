package com.icesi.sarec.api;

import com.icesi.sarec.dto.VehicleDTO;
import com.icesi.sarec.model.Vehicle;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/vehicle")
public interface VehicleApi {

    @PostMapping("/new")
    Vehicle createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO);

    @GetMapping("/get/all-by-user")
    List<Vehicle> getVehiclesByUser(@Valid @ParameterObject String userEmail);

}
