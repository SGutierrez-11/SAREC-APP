package com.icesi.sarec.api;

import com.icesi.sarec.dto.TransactionDTO;
import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.model.Transaction;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/transaction")
public interface TransactionApi {

    @PostMapping("/new")
    Transaction newTransaction(@Valid @RequestBody TransactionDTO transactionDTO);

    @GetMapping("/get/all-by-user")
    List<Transaction> getAllTransactionsByUser(@Valid @ParameterObject String userEmail);

    @GetMapping("/get/by-id")
    Transaction getTransactionById(@Valid @ParameterObject String id);
}
