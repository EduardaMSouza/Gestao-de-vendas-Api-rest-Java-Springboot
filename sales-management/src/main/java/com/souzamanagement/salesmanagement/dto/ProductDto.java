package com.souzamanagement.salesmanagement.dto;

import com.souzamanagement.salesmanagement.entity.CategoryModel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long code;
    @NotBlank(message = "The description must not be null/blank")
    @Size(min = 3, max = 100)
    private String description;
    @NotNull(message = "The quantity must not be null")
    @Min(0)
    @Max(10000)
    private int quantity;
    @NotNull(message = "The cost price must not be null")
    @Min(0)
    @Max(10000)
    private BigDecimal costPrice;
    @NotNull(message = "The selling price must not be null")
    @Min(0)
    @Max(100000)
    private BigDecimal sellingPrice;
    @NotBlank(message = "The observation must not be null/blank")
    @Size(min = 3, max = 50)
    private String observation;
    @NotNull(message = "The category must not be null")
    private CategoryDto category;
}
