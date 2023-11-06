package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.category.CategoryRequestDto;
import com.souzamanagement.salesmanagement.dto.category.CategoryResponseDto;
import com.souzamanagement.salesmanagement.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getProducts() {
        var categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CategoryResponseDto> getProduct(@PathVariable Long code) {
        var category = categoryService.getCategoryByCode(code);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> postCategory(@RequestBody @Valid CategoryRequestDto dto) {
        var savedCategory = categoryService.postCategory(dto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<CategoryResponseDto> putCategory(@RequestBody @Valid CategoryRequestDto dto, @PathVariable Long code) {
        var category = categoryService.putCategory(dto, code);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @DeleteMapping("/{code}")
    public ResponseEntity deleteCategory(@PathVariable Long code) {
        categoryService.deleteCategory(code);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
