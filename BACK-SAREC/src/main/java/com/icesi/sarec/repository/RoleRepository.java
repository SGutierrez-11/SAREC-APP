package com.icesi.sarec.repository;


import com.icesi.sarec.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT r FROM Role r where r.name = :name")
    Optional<Role> findByName(@Param("name")String name);
}