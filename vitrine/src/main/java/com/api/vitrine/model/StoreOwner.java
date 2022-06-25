package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "store_owner")
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
        //property = "id")
public class StoreOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store_owner")
    private long id;

    //@NonNull
    @Column(name = "name_owner", nullable = false)
    private String name;

    //@NonNull
    @Column(name = "email_owner", nullable = false, unique = true)
    private String email;

    //@NonNull
    @Column(name = "phone1", nullable = false)
    private String phone1;

    //@NonNull
    @Column(name = "phone2")
    private String phone2;

   // @NonNull
    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    //@NonNull
    @Column(name = "profile_picture")
    private String profilePicture;

    //@NonNull
    @Column(name = "cpf", unique=true, nullable = false)
    private String cpf;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeOwner")
    private List<Store> stores = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_user")
    public Usuario usuario;


}
