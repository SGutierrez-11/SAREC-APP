package com.icesi.sarec.api;

import com.icesi.sarec.dto.TransactionConfirmationDTO;
import com.icesi.sarec.model.TransactionConfirmation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/transaction-confirmation")
public interface TransactionConfirmationApi {

    @PostMapping ("/response")
    TransactionConfirmation registerTransactionConfirmation(@Valid @RequestBody TransactionConfirmationDTO transactionConfirmation);

    @GetMapping("/by-transaction-id")
    List<TransactionConfirmation> getTransactionConfirmationByTransactionId(@Valid @ParameterObject String transaction);
}
