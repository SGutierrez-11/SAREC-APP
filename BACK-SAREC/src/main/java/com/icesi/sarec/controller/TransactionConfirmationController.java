package com.icesi.sarec.controller;

import com.icesi.sarec.api.TransactionConfirmationApi;
import com.icesi.sarec.dto.TransactionConfirmationDTO;
import com.icesi.sarec.model.TransactionConfirmation;
import com.icesi.sarec.service.TransactionConfirmationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TransactionConfirmationController implements TransactionConfirmationApi {
    private final TransactionConfirmationService transactionConfirmationService;

    @Override
    public TransactionConfirmation registerTransactionConfirmation(TransactionConfirmationDTO transactionConfirmation) {
        return transactionConfirmationService.newTransactionConfirmation(transactionConfirmation);
    }

    @Override
    public List<TransactionConfirmation> getTransactionConfirmationByTransactionId(String transaction) {
        return transactionConfirmationService.getTransactionConfirmationByTransactionId(transaction);
    }

}
