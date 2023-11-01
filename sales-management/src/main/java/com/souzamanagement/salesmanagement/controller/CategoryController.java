package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.CategoryDto;
import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.repository.CategoryRepository;
import com.souzamanagement.salesmanagement.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getProducts() {
        var categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CategoryDto> getProduct(@PathVariable Long code) {
        var category = categoryService.getCategoryByCode(code);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
