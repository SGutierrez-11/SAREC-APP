package com.icesi.sarec.service;

import com.icesi.sarec.dto.TransactionDTO;
import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.model.Transaction;
import com.icesi.sarec.repository.TransactionRepository;
import com.icesi.sarec.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public Transaction newTransaction(TransactionDTO transaction){
        Transaction newTransaction = new Transaction();

        SarecUser user = userRepository.findByEmail(transaction.getUserEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        newTransaction.setUser(user);
        newTransaction.setUuid(java.util.UUID.randomUUID());
        newTransaction.setTimestamp(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setStatePol("4");

        return transactionRepository.save(newTransaction);
    }

    public List<Transaction> getTransactionsByUser(String userEmail){
        SarecUser transUser = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        return transactionRepository.findAllByUser(transUser);
    }

    public Transaction getTransactionById(String uuid){
        return transactionRepository.findById(java.util.UUID.fromString(uuid)).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
