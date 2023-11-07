package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.ShoppingCartItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItemModel, Long> {



    List<ShoppingCartItemModel> findAllByCartCode(Long cartCode);
}
