package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.CategoryDto;
import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ProductDto> postProduct(@RequestBody @Valid ProductDto dto) {
        var savedProduct = productService.postProduct(dto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ProductDto> putProduct(@RequestBody @Valid ProductDto dto, @PathVariable Long code) {
        var savedProduct = productService.putProduct(dto, code);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteProduct(@PathVariable Long code) {
        productService.deleteProduct(code);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
