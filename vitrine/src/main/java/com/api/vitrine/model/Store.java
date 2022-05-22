package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "store")
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<ProductCategory> productCategories;

    @ManyToOne
    @JoinColumn(name = "id_business_category")
    private BusinessCategory businessCategory;

    @ManyToOne
    @JoinColumn(name = "id_store_owner")
    private StoreOwner storeOwner;

    @OneToOne
    @JoinColumn(name = "id_address_store", referencedColumnName = "id_address_store")
    public AddressStore addressStore;
}
