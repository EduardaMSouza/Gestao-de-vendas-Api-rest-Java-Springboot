package com.souzamanagement.salesmanagement.service;


import com.souzamanagement.salesmanagement.repository.CartProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object getSaleItems(Long userCode) {
        var shoppingCart = shoppingCartService.getSale(userCode);
        System.out.println(shoppingCart);
        var saleItems = cartProductRepository.findByShoppingCartCode(shoppingCart.getCode());
        System.out.println("kkkkkkkkkkkkkkkkkkkk" + saleItems);
        return saleItems;
//        return saleItems.stream().map(saleItem -> modelMapper.map(saleItem, ShoppingCartItemResponseDto.class)).collect(Collectors.toList());
    }
}
