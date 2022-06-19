package com.api.vitrine.model;

import lombok.*;

import javax.persistence.*;


//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Builder

//ANNOTATION JPA

@Embeddable
public class AddressStore {


    //@NonNull
    @Column(name = "street")
    private String street;

    //@NonNull
    @Column(name = "neighborhood")
    private String neighborhood;

    //@NonNull
    @Column(name = "cep")
    private String cep;

    //NonNull
    @Column(name = "number")
    private String number;

    ///@NonNull
    @Column(name = "complement")
    private String complement;

    @NonNull
    @Column(name = "city")
    private String city;

    //@NonNull
    @Column(name = "uf")
    private String uf;
}
