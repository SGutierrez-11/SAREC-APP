package com.icesi.sarec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Toll {

    @Id
    private UUID uuid;

    private String name;
    private int line;
    private Long category1Price;
    private Long category2Price;
    private Long category3Price;
    private Long category4Price;
    private Long category5Price;
    private Long category6Price;
    private Long category7Price;
}
