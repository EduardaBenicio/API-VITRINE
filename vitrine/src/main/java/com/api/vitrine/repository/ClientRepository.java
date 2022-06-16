package com.api.vitrine.repository;

import com.api.vitrine.model.Client;
import com.api.vitrine.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT name_client, phone1, phone2, birth_date, profile_picture, cpf, id_user" +
            "FROM client", nativeQuery = true)
    public List<Client> findClient();

    @Query(value = "SELECT * FROM client WHERE email = ?1", nativeQuery = true)
    public Client findClientByEmail(String email);
}
