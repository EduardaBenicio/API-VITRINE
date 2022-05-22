package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "store_owner")
public class StoreOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store_owner")
    private long id;

    @NonNull
    @Column(name = "name_owner", nullable = false)
    private String name;

    @NonNull
    @Column(name = "phone1", nullable = false)
    private String phone1;

    @NonNull
    @Column(name = "phone2")
    private String phone2;

    @NonNull
    @Column(name = "birth_date")
    private String birthDate;

    @NonNull
    @Column(name = "profile_picture")
    private String profilePicture;

    @NonNull
    @Column(name = "cpf", unique=true, nullable = false)
    private String cpf;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeOwner")
    private List<Store> stores;

    @OneToOne
    @JoinColumn(name = "id_user")
    public Usuario usuario;


}
