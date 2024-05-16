package com.icesi.sarec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {

    private UUID toll;

    private String vehiclePlate;

    private long timestamp;

}