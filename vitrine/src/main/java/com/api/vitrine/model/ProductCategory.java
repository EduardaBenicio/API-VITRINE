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
@Table(name = "product_category")
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
       // property = "id")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_category")
    private long id;

    @NonNull
    @Column(name = "name_category")
    private String name;

    @NonNull
    @Column(name = "category_photo")
    private String categoryPhoto;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_store")
    private Store store;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private List<Product> products = new ArrayList<>();
}
