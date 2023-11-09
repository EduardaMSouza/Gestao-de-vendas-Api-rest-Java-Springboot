package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartModel, Long> {


    ShoppingCartModel findByUserCode(Long userCode);
}
