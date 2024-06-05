package com.shopPhuc.ShoppingOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Oder_Lines")
public class oderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_ID")
    private Integer orderLineId;

    private String quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ORDER_ID")
    private oder order;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCT_ID")
    private product product;
}
