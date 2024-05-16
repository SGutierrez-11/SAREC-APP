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
public class Admin {

    @Id
    private UUID uuid;

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String workId;
}
