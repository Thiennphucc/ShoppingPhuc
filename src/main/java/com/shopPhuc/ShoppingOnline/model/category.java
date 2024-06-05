package com.shopPhuc.ShoppingOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorys")
public class category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String categoryName;
    private String description;
    private String image;
    private Boolean active = true;
    @Temporal(TemporalType.DATE)
    private Date dateCreated=new Date();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<product> productList;


}
