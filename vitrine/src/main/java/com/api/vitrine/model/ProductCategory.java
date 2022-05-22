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
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_category")
    private long id;

    @NonNull
    @Column(name = "name_category")
    private String name;

    @NonNull
    @ManyToOne
    private Store store;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private List<Product> products;
}
