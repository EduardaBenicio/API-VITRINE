package com.api.vitrine.repository;

import com.api.vitrine.model.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Long> {
}
