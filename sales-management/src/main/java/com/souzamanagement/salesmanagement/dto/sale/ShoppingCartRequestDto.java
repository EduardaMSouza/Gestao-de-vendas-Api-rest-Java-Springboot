package com.souzamanagement.salesmanagement.dto.sale;

import com.souzamanagement.salesmanagement.entity.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartRequestDto {
    private String date;
    private UserModel user;
}
