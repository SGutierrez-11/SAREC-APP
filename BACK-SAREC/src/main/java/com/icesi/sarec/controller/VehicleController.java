package com.icesi.sarec.controller;

import com.icesi.sarec.api.VehicleApi;
import com.icesi.sarec.dto.VehicleDTO;
import com.icesi.sarec.model.Vehicle;
import com.icesi.sarec.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class VehicleController implements VehicleApi {

    private final VehicleService vehicleService;

    @Override
    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        return vehicleService.createVehicle(vehicleDTO);
    }

    @Override
    public List<Vehicle> getVehiclesByUser(String userEmail) {
        return vehicleService.getAllByUserEmail(userEmail);
    }
}
