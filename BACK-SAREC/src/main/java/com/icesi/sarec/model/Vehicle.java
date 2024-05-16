package com.icesi.sarec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    private String plate;

    @ManyToOne
    @JoinColumn
    private SarecUser user;

    private String vehicleClass;
    private String serviceType;
    private String licenseNumber;
    private int axiesAmount;
    private String runt;
    private Category category;
}
