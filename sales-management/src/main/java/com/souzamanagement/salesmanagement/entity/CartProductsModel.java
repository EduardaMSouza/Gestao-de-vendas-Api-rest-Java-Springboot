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
@Table(name = "cart_product")
public class CartProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @ManyToMany
    @JoinColumn(name = "product_code",referencedColumnName = "code")
    private List<ProductModel> products;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_code",referencedColumnName = "code")
    private ShoppingCartModel shoppingCart;
    private int quantity;
    private float cart_price;
}
