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
public class TransactionConfirmation {

    @Id
    private UUID transactionId;

    @ManyToOne
    @JoinColumn
    private Transaction transaction;

    private String statePol;
    private String responseCodePol;
    private int paymentMethod;
    private int installmentsNumber;
    private Long value;
    private Long tax;
    private Timestamp transactionDate;
    private String currency;
    private String emailBuyer;

}
