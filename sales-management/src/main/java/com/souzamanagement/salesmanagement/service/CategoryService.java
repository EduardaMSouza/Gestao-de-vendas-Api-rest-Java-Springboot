package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.CategoryDto;
import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.entity.CategoryModel;
import com.souzamanagement.salesmanagement.exception.AlreadyExistsException;
import com.souzamanagement.salesmanagement.exception.NotFoundException;
import com.souzamanagement.salesmanagement.repository.CategoryRepository;
import jakarta.transaction.Transactional;
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
        if(category == null) {
            throw new NotFoundException("Category with code " + code + " not found");
        }
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto postCategory(CategoryDto dto) {
        var existsByName = categoryRepository.existsByName(dto.getName());
        if(existsByName) {
            throw new AlreadyExistsException("Name already exists");
        }
        var category = modelMapper.map(dto, CategoryModel.class);
        var savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    public CategoryDto putCategory(CategoryDto dto, Long code) {
        var category = categoryRepository.findByCode(code);
        if(category == null) {
            throw new NotFoundException("Category with code " + code + " not found");
        }
        var existsByName = categoryRepository.existsByName(dto.getName());
        if(existsByName) {
            throw new AlreadyExistsException("Name already exists");
        }
        category.setName(dto.getName());
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryDto.class);
    }

    @Transactional
    public void deleteCategory(Long code) {
        var exists = categoryRepository.existsByCode(code);
        if(!exists) {
            throw new NotFoundException("Category with code " + code + " not found");
        }
        categoryRepository.deleteByCode(code);

    }
}
