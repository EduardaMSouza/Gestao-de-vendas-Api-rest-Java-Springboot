package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.ShoppingCartCompleteResponseDto;
import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.entity.ShoppingCartModel;
import com.souzamanagement.salesmanagement.repository.ShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Lazy
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCartCompleteResponseDto getShoppingCart(Long userCode) {
        var shoppingCartModel = shoppingCartRepository.findByUserCode(userCode);
        var cartProducts = cartProductService.findByCartCode(shoppingCartModel.getCode());
        var user = userService.getUserByCode(userCode);
        var products = cartProducts.stream()
                .map(cartProduct ->modelMapper.map(productService.getProductByCode(cartProduct.getProductCode()), ProductModel.class) )
                .collect(Collectors.toList());

        return new ShoppingCartCompleteResponseDto(shoppingCartModel,user, products);
    }
}
