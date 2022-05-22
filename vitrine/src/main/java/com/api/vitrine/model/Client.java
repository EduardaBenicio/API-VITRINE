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
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private long id;

    @NonNull
    @Column(name = "name_client", nullable = false)
    private String name;

    @NonNull
    @Column(name = "phone1", nullable = false)
    private String phone1;

    @NonNull
    @Column(name = "phone2")
    private String phone2;

    @NonNull
    @Column(name = "birth_date")
    private String birthDate;

    @NonNull
    @Column(name = "profile_picture")
    private String profilePicture;

    @NonNull
    @Column(name = "cpf", unique=true, nullable = false)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_user")
    public Usuario usuario;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="favorites_products",
            joinColumns=@JoinColumn(name="id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> favoritesProducts;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<AddressClient> addressClients;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Request> requests;
}
