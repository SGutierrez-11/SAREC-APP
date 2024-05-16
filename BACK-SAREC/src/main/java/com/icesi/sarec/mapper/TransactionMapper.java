package com.icesi.sarec.mapper;

import com.icesi.sarec.dto.TransactionDTO;
import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.model.Transaction;
import com.icesi.sarec.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction fromTransactionDto(TransactionDTO transaction);

}
