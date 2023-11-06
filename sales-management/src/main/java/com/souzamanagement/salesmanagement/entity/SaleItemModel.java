package com.souzamanagement.salesmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @ManyToOne
    @JoinColumn(name = "product_code",referencedColumnName = "code")
    private ProductModel product;
    @ManyToOne
    @JoinColumn(name = "sale_code",referencedColumnName = "code")
    private SaleModel sale;
    private int quantity;
    private float sale_price;
}
