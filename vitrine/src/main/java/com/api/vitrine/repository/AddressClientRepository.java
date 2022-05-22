package com.api.vitrine.repository;

import com.api.vitrine.model.AddressClient;
import com.api.vitrine.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressClientRepository extends JpaRepository<AddressClient, Long> {

    @Query(value = "SELECT * FROM address_client where id_client = ?1", nativeQuery = true)
    public List<AddressClient> findByClient(long id);
}
