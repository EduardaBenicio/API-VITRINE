package com.api.vitrine.repository;

import com.api.vitrine.model.AddressStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStoreRepository extends JpaRepository<AddressStore, Long> {
}
