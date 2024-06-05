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
@Entity
@Table(name = "oder_Status")
public class oderStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Oder_Status_Id")
    private Long id;
    @Column(name = "Oder_Status")
    private String OderStatusName;

    @OneToMany(mappedBy="status")
    private List<oder> oders;

}
