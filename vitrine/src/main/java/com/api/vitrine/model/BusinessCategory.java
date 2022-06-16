package com.api.vitrine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//ANNOTATION JPA

@Entity
@Table(name = "business_category")
//@JsonIdentityInfo(
        //generator = ObjectIdGenerators.PropertyGenerator.class,
      //  property = "id")
public class BusinessCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_business_category")
    private long id;

    @NonNull
    @Column(name = "name_category")
    private String name;

    @NonNull
    @Column(name = "category_photo")
    private String categoryPhoto;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessCategory", fetch = FetchType.LAZY)
    private List<Store> stores = new ArrayList<>();
}
