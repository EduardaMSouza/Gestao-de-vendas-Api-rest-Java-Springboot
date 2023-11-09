package com.souzamanagement.salesmanagement.service;


import com.souzamanagement.salesmanagement.entity.CartProductsModel;
import com.souzamanagement.salesmanagement.repository.CartProductRepository;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<CartProductsModel> findByCartCode(Long code) {
        return cartProductRepository.findAllByCartCode(code);
    }
}
