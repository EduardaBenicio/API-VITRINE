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
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//ANNOTATION JPA
@Entity
@Table(name = "request")
//@JsonIdentityInfo(
        //generator = ObjectIdGenerators.PropertyGenerator.class,
       // property = "id")
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

    @JsonManagedReference
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<RequestProducts> requestProducts = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;


}
