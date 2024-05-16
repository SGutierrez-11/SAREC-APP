package com.icesi.sarec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    @Id
    private UUID uuid;

    @ManyToOne
    @JoinColumn
    private SarecUser user;

    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn
    private Toll toll;

    private Timestamp timestamp;
    private Status status;

}
