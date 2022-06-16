package com.api.vitrine.repository;

import com.api.vitrine.model.Product;
import com.api.vitrine.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "SELECT * FROM request WHERE id_client = ?1", nativeQuery = true)
    public List<Request> findAllClient(long id);


}
