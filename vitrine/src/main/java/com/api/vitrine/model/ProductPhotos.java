package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

//ANNOTATION JPA
@Entity
@Table(name = "product_photos")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductPhotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_photos")
    private long id;

    @NonNull
    @Column(name = "photo")
    private String photo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;



}
