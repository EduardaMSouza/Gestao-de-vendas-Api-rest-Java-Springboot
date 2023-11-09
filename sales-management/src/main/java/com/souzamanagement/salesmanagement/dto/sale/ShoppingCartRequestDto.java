package com.souzamanagement.salesmanagement.dto.sale;

import com.souzamanagement.salesmanagement.entity.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartRequestDto {
    private int quantity;
    private BigDecimal cartPrice;
    private Date date;
    private UserModel userCode;
}
