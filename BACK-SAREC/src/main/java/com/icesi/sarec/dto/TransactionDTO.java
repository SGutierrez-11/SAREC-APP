package com.icesi.sarec.dto;

import com.icesi.sarec.model.SarecUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private String userEmail;
    private Long amount;

}
