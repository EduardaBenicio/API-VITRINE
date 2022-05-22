package com.api.vitrine.model;


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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    //ROLE_ADMIN ROLE_USER
    @NonNull
    private String authorities;
}
