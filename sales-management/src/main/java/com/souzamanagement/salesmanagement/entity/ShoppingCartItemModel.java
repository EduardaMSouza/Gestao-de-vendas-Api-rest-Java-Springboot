package com.souzamanagement.salesmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @ManyToMany
    @JoinColumn(name = "product_code",referencedColumnName = "code")
    private List<ProductModel> products;
    @ManyToOne
    @JoinColumn(name = "cart_code",referencedColumnName = "code")
    private ShoppingCartModel shopping_cart;
    private int quantity;
    private float cart_price;
}
