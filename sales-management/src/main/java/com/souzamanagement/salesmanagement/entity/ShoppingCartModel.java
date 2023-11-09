package com.souzamanagement.salesmanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private int quantity;
    @Column(name = "cart_price")
    private BigDecimal cartPrice;
    private Date date;
    private Long userCode;
}
