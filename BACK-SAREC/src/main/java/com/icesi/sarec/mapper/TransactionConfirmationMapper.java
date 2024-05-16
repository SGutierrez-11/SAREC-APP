package com.icesi.sarec.mapper;

import com.icesi.sarec.dto.TransactionConfirmationDTO;
import com.icesi.sarec.model.TransactionConfirmation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionConfirmationMapper {

    @Mapping(target = "transactionId", ignore = true)
    @Mapping(target = "transaction", ignore = true)
    @Mapping(target = "transactionDate", expression = "java(java.sql.Timestamp.valueOf(transactionConfirmation.getTransactionDate()))")
    TransactionConfirmation transactionConfirmationDTOToTransactionConfirmation(TransactionConfirmationDTO transactionConfirmation);
}
