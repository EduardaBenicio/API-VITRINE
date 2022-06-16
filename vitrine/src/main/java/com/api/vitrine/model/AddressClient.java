package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;


//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "address_client")
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
        //property = "id")
public class AddressClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address_client")
    private long id;

    @NonNull
    @Column(name = "street")
    private String street;

    @NonNull
    @Column(name = "district")
    private String district;

    @NonNull
    @Column(name = "cep")
    private String cep;

    @NonNull
    @Column(name = "number")
    private String number;

    @NonNull
    @Column(name = "complement")
    private String complement;

    @NonNull
    @Column(name = "uf")
    private String uf;

    @NonNull
    @Column(name = "main")
    private boolean main;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
