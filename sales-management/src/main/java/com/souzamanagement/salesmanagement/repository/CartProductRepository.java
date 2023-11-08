package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.CartProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProductsModel, Long> {

    List<CartProductsModel> findByShoppingCartCode(Long cartCode);

//    @Query("SELECT sci, p as products, sc FROM ShoppingCartItemModel sci, ProductModel p, ShoppingCartModel sc WHERE sci.shopping_cart.code = :cartCode")
//    List<ShoppingCartItemModel> findAllByShoppingCartCode(Long CartCode);
}
