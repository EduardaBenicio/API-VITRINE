package com.api.vitrine.repository;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.RequestProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestProductRepository extends JpaRepository<RequestProducts, Long> {

}
