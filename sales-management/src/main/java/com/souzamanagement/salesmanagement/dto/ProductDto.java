package com.souzamanagement.salesmanagement.dto;

import com.souzamanagement.salesmanagement.entity.CategoryModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long code;
    private String description;
    private int quantity;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private String observation;
    private CategoryModel category;
}
