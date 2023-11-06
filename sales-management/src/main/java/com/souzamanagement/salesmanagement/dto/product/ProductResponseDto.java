package com.souzamanagement.salesmanagement.dto.product;

import com.souzamanagement.salesmanagement.dto.category.CategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
    private Long code;
    private String description;
    private int quantity;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private String observation;
    private CategoryResponseDto category;

}
