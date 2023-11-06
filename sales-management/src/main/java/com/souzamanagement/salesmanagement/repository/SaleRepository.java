package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleModel, Long> {
    SaleModel findByUserCode(Long userCode);
}
