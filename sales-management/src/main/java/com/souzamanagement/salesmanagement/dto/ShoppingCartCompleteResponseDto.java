package com.souzamanagement.salesmanagement.dto;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import com.souzamanagement.salesmanagement.entity.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartCompleteResponseDto {
    private ShoppingCartModel shoppingCartModel;
    private UserModel userModel;
    private List<ProductModel> productModels;
}
