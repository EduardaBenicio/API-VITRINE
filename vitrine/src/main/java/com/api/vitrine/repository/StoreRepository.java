package com.api.vitrine.repository;

import com.api.vitrine.model.Store;
import com.api.vitrine.model.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "SELECT * FROM store where id_store_owner = ?1", nativeQuery = true)
    public List<Store> findByOwner(long id);

    @Query(value = "SELECT * FROM store WHERE id_business_category = ?1", nativeQuery = true)
    public List<Store> findStore(long id);
}
