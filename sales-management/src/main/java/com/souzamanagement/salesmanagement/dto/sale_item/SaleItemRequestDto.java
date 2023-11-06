package com.souzamanagement.salesmanagement.dto.sale_item;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.SaleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleItemRequestDto {
    private ProductModel product;
    private SaleModel sale;
    private int quantity;
    private float sale_price;
}
