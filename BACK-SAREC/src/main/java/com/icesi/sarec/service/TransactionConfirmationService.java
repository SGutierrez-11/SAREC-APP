package com.icesi.sarec.service;

import com.icesi.sarec.dto.TransactionConfirmationDTO;
import com.icesi.sarec.mapper.TransactionConfirmationMapper;
import com.icesi.sarec.model.Transaction;
import com.icesi.sarec.model.TransactionConfirmation;
import com.icesi.sarec.repository.TransactionConfirmationRepository;
import com.icesi.sarec.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionConfirmationService {

    private final TransactionConfirmationRepository transactionConfirmationRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionConfirmationMapper transactionConfirmationMapper;
    private final TransactionService transactionService;

    @Autowired
    private Environment env;

    public TransactionConfirmation newTransactionConfirmation(TransactionConfirmationDTO transactionConfirmation){
        TransactionConfirmation newTransactionConfirmation = transactionConfirmationMapper.transactionConfirmationDTOToTransactionConfirmation(transactionConfirmation);

        newTransactionConfirmation.setTransactionId(java.util.UUID.randomUUID());
        newTransactionConfirmation.setTransaction(transactionService.getTransactionById(transactionConfirmation.getReferenceSale()));
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String apiKey = env.getProperty("payu.apikey");
        String merchantId = env.getProperty("payu.merchantid");
        String toParseSign = apiKey+"~"+merchantId+"~"+newTransactionConfirmation.getTransaction().getUuid().toString()+"~"+formatLong(newTransactionConfirmation.getValue())+"~"+newTransactionConfirmation.getCurrency()+"~"+newTransactionConfirmation.getStatePol();
        String obtainedSign = bytesToHex(md.digest(toParseSign.getBytes(StandardCharsets.UTF_8)));
        if (!obtainedSign.equals(transactionConfirmation.getSign())) {
            throw new RuntimeException("Signs don't match");
        }

        if (newTransactionConfirmation.getStatePol().equals("4")){
            if (newTransactionConfirmation.getTransaction().getStatePol().equals("4")){
                throw new RuntimeException("Transaction already confirmed");
            }
            newTransactionConfirmation.getTransaction().setStatePol("4");
            newTransactionConfirmation.getTransaction().getUser().setBalance(newTransactionConfirmation.getValue() + newTransactionConfirmation.getTransaction().getUser().getBalance());
        }

        return transactionConfirmationRepository.save(newTransactionConfirmation);
    }

    public List<TransactionConfirmation> getTransactionConfirmationByTransactionId(String transaction){
        Transaction foundTransaction = transactionRepository.findByUuid(java.util.UUID.fromString(transaction));
        return transactionConfirmationRepository.findAllByTransaction(foundTransaction);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String formatLong(Long number) {
        DecimalFormat df = new DecimalFormat("#.##");
        String resultado = df.format(number);
        if (resultado.endsWith(".0")) {
            resultado = resultado.substring(0, resultado.length() - 2) + ".0";
        } else if (!resultado.contains(".")) {
            resultado += ".0";
        }
        return resultado;
    }
}
