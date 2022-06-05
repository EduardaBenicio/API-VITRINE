package com.api.vitrine.repository;

import com.api.vitrine.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE username = ?1", nativeQuery = true)
    Usuario findByUsername (String username);

    @Query(value = "SELECT * FROM usuarios WHERE username = ?1 AND password =  ?2 LIMIT 1", nativeQuery = true)
    Usuario Login (String username, String passoword);
}
