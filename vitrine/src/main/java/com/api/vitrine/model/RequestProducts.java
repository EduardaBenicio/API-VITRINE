package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
//ANNOTATION LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

// ANNOTATTION JPA
@Entity
@Table(name = "request_products")
//@JsonIdentityInfo(
       // generator = ObjectIdGenerators.PropertyGenerator.class,
       // property = "id")
public class RequestProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request_products")
    private long id;

    @NonNull
    @Column(name = "quantity")
    private int quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_request")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;


}
