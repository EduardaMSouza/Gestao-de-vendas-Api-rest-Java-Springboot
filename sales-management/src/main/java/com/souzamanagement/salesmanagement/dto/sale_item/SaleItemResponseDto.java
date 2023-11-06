package com.souzamanagement.salesmanagement.dto.sale_item;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.SaleModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleItemResponseDto {
    private Long code;
    private ProductModel product;
    private SaleModel sale;
    private int quantity;
    private float sale_price;
}
