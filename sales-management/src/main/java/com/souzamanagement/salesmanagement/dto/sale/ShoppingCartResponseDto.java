package com.souzamanagement.salesmanagement.dto.sale;

import com.souzamanagement.salesmanagement.entity.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartResponseDto {
    private long code;
    private int quantity;
    private BigDecimal cartPrice;
    private Date date;
    private UserModel userCode;
}
