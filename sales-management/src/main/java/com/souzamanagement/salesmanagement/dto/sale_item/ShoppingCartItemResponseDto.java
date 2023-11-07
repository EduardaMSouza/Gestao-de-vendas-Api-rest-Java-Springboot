package com.souzamanagement.salesmanagement.dto.sale_item;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemResponseDto {
    private Long code;
    private List<ProductModel> product;
    private ShoppingCartModel cart;
    private int quantity;
    private float cart_price;
}
