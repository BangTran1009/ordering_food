package com.team3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String name;
    @Column(nullable=false, unique=true)
    private String slug;
    @Column(nullable = false)
    private int price;
    @Column(length = 1000, nullable = false)
    private String description;
    @Column(nullable = false)
    private String audioUrl;
    @Column(nullable = false)
    private String imgUrl;

    @ManyToMany
    @JoinTable(
            name = "cart_item",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Cart> cartItem;

    @OneToOne(mappedBy = "product")
    private OrderDetails orderDetail;

    @OneToOne(mappedBy = "product")
    private Promotions promotion;
}
