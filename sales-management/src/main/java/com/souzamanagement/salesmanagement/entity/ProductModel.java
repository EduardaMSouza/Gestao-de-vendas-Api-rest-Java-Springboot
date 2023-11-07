package com.souzamanagement.salesmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "costPrice")
    private BigDecimal costPrice;
    @Column(name = "sellingPrice")
    private BigDecimal sellingPrice;
    @Column(name = "observation")
    private String observation;
    @ManyToOne
    @JoinColumn(name = "category_code", referencedColumnName = "code")
    private CategoryModel category;
}
