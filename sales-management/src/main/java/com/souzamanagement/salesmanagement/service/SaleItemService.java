package com.souzamanagement.salesmanagement.service;


import com.souzamanagement.salesmanagement.dto.sale_item.SaleItemResponseDto;
import com.souzamanagement.salesmanagement.repository.SaleItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleItemService {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SaleItemResponseDto> getSaleItems(Long userCode) {
        var sale = saleService.getSale(userCode);
        System.out.println(sale + "kkkkkkkkkkkkkkkkkkkkkk" );
        var saleItems = saleItemRepository.findAllBySaleCode(sale.getCode());
        return saleItems.stream().map(saleItem -> modelMapper.map(saleItem, SaleItemResponseDto.class)).collect(Collectors.toList());
    }
}
