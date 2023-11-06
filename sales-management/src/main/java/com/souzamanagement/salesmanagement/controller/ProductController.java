package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.product.ProductRequestDto;
import com.souzamanagement.salesmanagement.dto.product.ProductResponseDto;
import com.souzamanagement.salesmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        var products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long code) {
        var product = productService.getProductByCode(code);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> postProduct(@RequestBody @Valid ProductRequestDto dto) {
        var savedProduct = productService.postProduct(dto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ProductResponseDto> putProduct(@RequestBody @Valid ProductRequestDto dto, @PathVariable Long code) {
        var savedProduct = productService.putProduct(dto, code);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteProduct(@PathVariable Long code) {
        productService.deleteProduct(code);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
