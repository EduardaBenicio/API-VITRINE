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
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private long id;

    @NonNull
    @Column(name = "date")
    private String data;

    @NonNull
    @Column(name = "number", unique = true)
    private long number;

    @NonNull
    @Column(name = "total")
    private double total;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="pedido_produtos",
            joinColumns=@JoinColumn(name="id_request"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;


}
