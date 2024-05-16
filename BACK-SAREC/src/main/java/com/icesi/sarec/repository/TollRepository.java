package com.icesi.sarec.repository;

import com.icesi.sarec.model.Toll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TollRepository extends JpaRepository<Toll, UUID> {
}
