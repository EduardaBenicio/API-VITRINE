package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
        //property = "id")
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


    private long quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_product_category")
    private ProductCategory productCategory;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductPhotos> productPhotos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "favoritesProducts")
    private List<Client> clients = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "cartProducts")
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specifications> specifications =  new ArrayList<>();



}
