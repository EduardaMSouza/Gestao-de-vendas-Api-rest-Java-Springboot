package com.souzamanagement.salesmanagement.dto.sale;

import com.souzamanagement.salesmanagement.entity.UserModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleResponseDto {
    private Long code;
    private String date;
    private UserModel user;
}
