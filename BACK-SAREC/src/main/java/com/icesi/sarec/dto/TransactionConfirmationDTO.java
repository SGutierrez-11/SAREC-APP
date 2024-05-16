package com.icesi.sarec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionConfirmationDTO {

    @NotBlank
    private String merchantId;

    @NotBlank
    private String referenceSale;

    @NotBlank
    private Long value;

    @NotBlank
    private String currency;

    @NotBlank
    private String statePol;

    @NotBlank
    private String sign;

    private String responseCodePol;
    private int paymentMethod;
    private int installmentsNumber;
    private Long tax;
    private String transactionDate;
    private String emailBuyer;

}
