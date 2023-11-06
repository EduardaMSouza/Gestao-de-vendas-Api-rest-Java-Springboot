package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.SaleItemModel;
import com.souzamanagement.salesmanagement.entity.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItemModel, Long> {

    List<SaleItemModel> findAllBySaleCode(Long code);
}
