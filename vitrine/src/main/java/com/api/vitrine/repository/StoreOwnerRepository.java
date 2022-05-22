package com.api.vitrine.repository;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {

}
