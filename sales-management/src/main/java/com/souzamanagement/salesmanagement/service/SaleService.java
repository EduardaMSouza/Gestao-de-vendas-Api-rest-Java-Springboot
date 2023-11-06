package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.entity.SaleModel;
import com.souzamanagement.salesmanagement.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SaleModel getSale(Long userCode) {
        var sale = saleRepository.findByUserCode(userCode);
        return sale;
//        return modelMapper.map(sale, SaleItemResponseDto.class);
//        var sale = saleItemRepository.findByUser(userCode);
    }
}
