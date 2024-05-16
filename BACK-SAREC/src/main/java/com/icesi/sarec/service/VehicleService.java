package com.icesi.sarec.service;

import com.icesi.sarec.dto.VehicleDTO;
import com.icesi.sarec.mapper.VehicleMapper;
import com.icesi.sarec.model.Category;
import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.model.Vehicle;
import com.icesi.sarec.repository.UserRepository;
import com.icesi.sarec.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final VehicleMapper vehicleMapper;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.vehicleDTOToVehicle(vehicleDTO);
        SarecUser user = userRepository.findByEmail(vehicleDTO.getUserEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        switch (vehicleDTO.getCategory()){
            case "PESADO":
                vehicle.setCategory(Category.PESADO);
                break;
            case "MOTOCICLETA":
                vehicle.setCategory(Category.MOTOCICLETA);
                break;
            case "LIGERO":
                vehicle.setCategory(Category.LIGERO);
                break;
        }
        vehicle.setUser(user);

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllByUserEmail(String email) {
        return vehicleRepository.findAllByUserEmail(email);
    }

}
