package com.shopPhuc.ShoppingOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="User_ID")
    private Long id;

    private String username;
    private String password;
    private String email;
    @Column(nullable=false)
    private Boolean gender;
    private Integer phone;
    private String address;
    Boolean admin;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<oder> orders;
}
