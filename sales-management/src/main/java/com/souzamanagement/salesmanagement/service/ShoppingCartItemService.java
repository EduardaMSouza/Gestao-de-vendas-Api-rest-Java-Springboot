package com.souzamanagement.salesmanagement.service;


import com.souzamanagement.salesmanagement.dto.sale_item.ShoppingCartItemResponseDto;
import com.souzamanagement.salesmanagement.repository.ShoppingCartItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ShoppingCartItemResponseDto> getSaleItems(Long userCode) {
        var shoppingCart = shoppingCartService.getSale(userCode);
        System.out.println(shoppingCart);
        var saleItems = shoppingCartItemRepository.findAllByCartCode(shoppingCart.getCode());
        return saleItems.stream().map(saleItem -> modelMapper.map(saleItem, ShoppingCartItemResponseDto.class)).collect(Collectors.toList());
    }
}
