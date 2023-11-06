package com.souzamanagement.salesmanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String date;
    @ManyToOne
    @JoinColumn(name = "user_code", referencedColumnName = "code")
    private UserModel user;
}
