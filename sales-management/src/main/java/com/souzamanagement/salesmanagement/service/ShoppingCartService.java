package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import com.souzamanagement.salesmanagement.repository.ShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCartModel getSale(Long userCode) {
        var sale = shoppingCartRepository.findByUserCode(userCode);
        return sale;
//        return modelMapper.map(sale, SaleItemResponseDto.class);
//        var sale = saleItemRepository.findByUser(userCode);
    }
}
