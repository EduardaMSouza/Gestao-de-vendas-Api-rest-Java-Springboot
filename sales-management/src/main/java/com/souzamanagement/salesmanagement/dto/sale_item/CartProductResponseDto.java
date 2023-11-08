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
public class CartProductResponseDto {
    private Long code;
    private List<ProductModel> products;
    private ShoppingCartModel cart;
    private int quantity;
    private float cart_price;
}
