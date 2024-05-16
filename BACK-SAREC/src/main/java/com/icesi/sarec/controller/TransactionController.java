package com.icesi.sarec.controller;

import com.icesi.sarec.api.TransactionApi;
import com.icesi.sarec.dto.TransactionDTO;
import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.model.Transaction;
import com.icesi.sarec.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TransactionController implements TransactionApi {
    private final TransactionService transactionService;

    @Override
    public Transaction newTransaction(TransactionDTO transactionDTO) {
        return transactionService.newTransaction(transactionDTO);
    }

    @Override
    public List<Transaction> getAllTransactionsByUser(String userEmail) {
        return transactionService.getTransactionsByUser(userEmail);
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionService.getTransactionById(id);
    }

}
