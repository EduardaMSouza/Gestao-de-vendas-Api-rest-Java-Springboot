package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping_cart")
public class CartProductController {

    @Autowired
    private ShoppingCartService shoppingCarService;

    @GetMapping("/{userCode}")
    public ResponseEntity<Object> getShoppingCart(@PathVariable Long userCode) {
        var sale = shoppingCarService.getShoppingCart(userCode);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }
}
