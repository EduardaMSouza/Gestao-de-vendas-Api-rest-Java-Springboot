package com.souzamanagement.salesmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {
    @NotBlank(message = "The description must not be null/blank")
    @Size(min = 3, max = 100, message = "The description must have between 3 and 100 characters")
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
    @Size(min = 3, max = 50, message = "The observation must have between 3 and 50 characters")
    private String observation;
    @NotNull(message = "The category must not be null")
    private CategoryResponseDto category;
}
