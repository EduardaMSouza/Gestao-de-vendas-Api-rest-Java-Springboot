package com.souzamanagement.salesmanagement.dto.sale_item;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartProductRequestDto {
    private ProductModel product;
    private ShoppingCartModel cart;
    private int quantity;
    private float cart_price;
}
