package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    ProductModel findByCode(Long code);

    void deleteByCode(Long code);

    boolean existsByCode(Long code);

    boolean existsByDescription(String description);

    List<ProductModel> findByCategoryCode(Long categoryCode);
}
