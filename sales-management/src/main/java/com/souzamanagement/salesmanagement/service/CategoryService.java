package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.CategoryDto;
import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoryDto> getCategories() {
        var categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    public CategoryDto getCategoryByCode(Long code) {
        var category = categoryRepository.findByCode(code);
        return modelMapper.map(category, CategoryDto.class);
    }

}
