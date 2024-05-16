package com.icesi.sarec.repository;


import com.icesi.sarec.model.SarecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<SarecUser, Long> {

    @Query(value = "SELECT u FROM SarecUser u where u.email= :email")
    Optional<SarecUser> findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM SarecUser u where u.phoneNumber= :phone")
    Optional<SarecUser> findByPhoneNumber(@Param("phone") String phone);

    @Query(value = "SELECT u FROM SarecUser u where u.name= :name")
    Optional<SarecUser> findByName(@Param("name") String name);

    @Query("SELECT v.user FROM Vehicle v WHERE v.plate = :plate")
    Optional<SarecUser> findByPlate(@Param("plate") String plate);





}