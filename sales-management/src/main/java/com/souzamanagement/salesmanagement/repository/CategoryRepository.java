package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    CategoryModel findByCode(Long code);

    void deleteByCode(Long code);

    boolean existsByCode(Long code);

    boolean existsByName(String name);
}
