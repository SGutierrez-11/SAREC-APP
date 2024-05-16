package com.icesi.sarec.repository;


import com.icesi.sarec.model.Record;
import com.icesi.sarec.model.SarecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecordRepository extends JpaRepository<Record, UUID> {

    @Query("SELECT r FROM Record r WHERE r.user = :sarecUser")
    Optional<Record> findBySarecUser(@Param("sarecUser") SarecUser sarecUser);

    @Query("SELECT r FROM Record r WHERE r.uuid = :id")
    Optional<Record> findById(@Param("id") UUID id);

    Record save(Record record);

    List<Record> getAllByUserEmail(String email);

}