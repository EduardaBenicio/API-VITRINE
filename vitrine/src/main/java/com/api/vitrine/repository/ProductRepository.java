package com.api.vitrine.repository;

import com.api.vitrine.model.Product;
import com.api.vitrine.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE id_product_category = ?1", nativeQuery = true)
    public List<Product> findByProductCategory(long id);

}
