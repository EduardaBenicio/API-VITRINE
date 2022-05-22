package com.api.vitrine.model;

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
@Table(name = "address_store")
public class AddressStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address_store")
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




}
