package com.api.vitrine.repository;

import com.api.vitrine.model.ProductCategory;
import com.api.vitrine.model.ProductPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPhotosRepository extends JpaRepository<ProductPhotos, Long> {

    @Query(value = "SELECT id_product_photos, photo FROM product_photos where id_product = ?1", nativeQuery = true)
    public List<ProductPhotos> findPhotos(long id);
}
