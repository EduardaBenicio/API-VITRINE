package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "specification")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specification")
    private long id;

    //CHAVE ESTRANGEIRA
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @NonNull
    @Column(name = "name_specification")
    private String name;

    @NonNull
    @Column(name = "specification")
    private String specification;

}
