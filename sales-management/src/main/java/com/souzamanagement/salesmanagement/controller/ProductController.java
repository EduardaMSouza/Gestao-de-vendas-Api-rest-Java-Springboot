package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        var products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long code) {
        var product = productService.getProductByCode(code);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
