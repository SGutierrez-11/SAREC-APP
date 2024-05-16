package com.icesi.sarec.repository;

import com.icesi.sarec.model.Transaction;
import com.icesi.sarec.model.TransactionConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionConfirmationRepository extends JpaRepository<TransactionConfirmation, UUID> {

    List<TransactionConfirmation> findAllByTransaction (Transaction transaction);
}
