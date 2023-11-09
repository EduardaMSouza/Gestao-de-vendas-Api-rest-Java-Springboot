package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.CartProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProductsModel, Long> {


    List<CartProductsModel> findAllByCartCode(Long cartCode);
}
