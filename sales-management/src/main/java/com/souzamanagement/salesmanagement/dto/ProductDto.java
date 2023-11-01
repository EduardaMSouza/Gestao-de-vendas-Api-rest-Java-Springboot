package com.souzamanagement.salesmanagement.dto;

import com.souzamanagement.salesmanagement.entity.CategoryModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long code;
    @NotBlank
    private String description;
    @NotNull
    private int quantity;
    @NotNull
    private BigDecimal costPrice;
    @NotNull
    private BigDecimal sellingPrice;
    @NotBlank
    private String observation;
    @NotNull
    private CategoryModel category;
}
