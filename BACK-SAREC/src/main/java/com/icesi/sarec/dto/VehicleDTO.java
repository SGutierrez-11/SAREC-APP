package com.icesi.sarec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private String plate;
    private String userEmail;
    private String vehicleClass;
    private String serviceType;
    private String licenseNumber;
    private int axiesAmount;
    private String runt;
    private String category;

}
