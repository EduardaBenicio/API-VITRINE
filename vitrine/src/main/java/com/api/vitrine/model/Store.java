package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
@Table(name = "store")
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
        //property = "id")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store")
    private long id;

    @NonNull
    @Column(name = "fantasy_name")
    private String fantasyName;

    @NonNull
    @Column(name = "cnpj", unique=true)
    private String cnpj;

    @NonNull
    @Column(name = "social_reason")
    private String socialReason;

    @NonNull
    @Column(name = "logo")
    private String logo;

    @NonNull
    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<ProductCategory> productCategories = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "id_business_category")
    private BusinessCategory businessCategory;

    @ManyToOne
    @JoinColumn(name = "id_store_owner")
    private StoreOwner storeOwner;

    @Embedded
    public AddressStore addressStore;



}
