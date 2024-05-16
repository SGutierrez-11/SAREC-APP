package com.icesi.sarec.model;



import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SarecUser {
    @Id
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private Long balance;

    @ManyToOne
    @JoinColumn(name = "role_role_id")
    private Role role;

}