package com.api.vitrine.repository;

import com.api.vitrine.model.BusinessCategory;
import com.api.vitrine.model.Client;
import com.api.vitrine.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {


}
