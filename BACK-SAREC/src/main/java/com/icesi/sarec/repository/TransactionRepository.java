package com.icesi.sarec.repository;

import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findAllByUser(SarecUser user);

    Transaction findByUuid(UUID uuid);
}
