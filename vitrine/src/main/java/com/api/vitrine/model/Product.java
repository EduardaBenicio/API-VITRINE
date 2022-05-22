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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;

    @NonNull
    @Column(name = "name_product", nullable = false)
    private String name;

    @NonNull
    @Column(name = "cost", nullable = false)
    private double cost;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "in_stock", nullable = false)
    private long inStock;

    @ManyToOne
    @JoinColumn(name = "id_product_category")
    private ProductCategory productCategory;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Request> request;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductPhotos> productPhotos;

    @JsonIgnore
    @ManyToMany(mappedBy = "favoritesProducts")
    private List<Client> clients;

    @JsonIgnore
    @ManyToMany(mappedBy = "cartProducts")
    private List<ShoppingCart> shoppingCarts;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specifications> specifications;

}
