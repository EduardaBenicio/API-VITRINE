package com.api.vitrine.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//ANNOTATION LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//ANNOTATION JPA
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart")
    private long id;

    @NonNull
    @Column(name = "number")
    private double total;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="cart_produtos",
            joinColumns=@JoinColumn(name="id_shopping_cart"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> cartProducts;

}
