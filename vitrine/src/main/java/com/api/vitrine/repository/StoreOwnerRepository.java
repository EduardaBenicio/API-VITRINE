package com.api.vitrine.repository;

import com.api.vitrine.model.Client;
import com.api.vitrine.model.Request;
import com.api.vitrine.model.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {

    @Query(value = "SELECT * FROM store_owner WHERE email_owner = ?1", nativeQuery = true)
    public StoreOwner findOwnerByEmail(String email);
}
