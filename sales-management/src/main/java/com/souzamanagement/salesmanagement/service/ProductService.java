package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.product.ProductRequestDto;
import com.souzamanagement.salesmanagement.dto.product.ProductResponseDto;
import com.souzamanagement.salesmanagement.entity.CartProductsModel;
import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.exception.AlreadyExistsException;
import com.souzamanagement.salesmanagement.exception.NotFoundException;
import com.souzamanagement.salesmanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductResponseDto> getProducts() {
        var products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
        return productResponseDtos;
    }

    public ProductResponseDto getProductByCode(Long code) {
        var product = productRepository.findByCode(code);
        if(product == null) {
            throw new NotFoundException("Product with code " + code + " not found");
        }
        return modelMapper.map(product, ProductResponseDto.class);
    }

    public List<ProductResponseDto> getProductByCategory(Long categoryCode) {
        var product = productRepository.findByCategoryCode(categoryCode);
        List<ProductResponseDto> productsDtos = product.stream()
                .map(products -> modelMapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
        return productsDtos;
    }

    public ProductResponseDto postProduct(ProductRequestDto dto) {
        var existsByName = productRepository.existsByDescription(dto.getDescription());
        if(existsByName) {
            throw new AlreadyExistsException("Description already exists");
        }
        var product = modelMapper.map(dto, ProductModel.class);
        var savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponseDto.class);
    }

    public ProductResponseDto putProduct(ProductRequestDto dto, Long code) {
        var product = productRepository.findByCode(code);
        if(product == null) {
            throw new NotFoundException("Product with code " + code + " not found");
        }
        var existsByDescription = productRepository.existsByDescription(dto.getDescription());
        if(existsByDescription) {
            throw new AlreadyExistsException("Description already exists");
        }
        product.setQuantity(dto.getQuantity());
        product.setObservation(dto.getObservation());
        product.setDescription(dto.getDescription());
        product.setCostPrice(dto.getCostPrice());
        product.setSellingPrice(dto.getSellingPrice());
        productRepository.save(product);
        return modelMapper.map(product, ProductResponseDto.class);
    }

    @Transactional
    public void deleteProduct(Long code) {
        var exists = productRepository.existsByCode(code);
        if(!exists) {
            throw new NotFoundException("Product with code " + code + " not found");
        }
        productRepository.deleteByCode(code);

    }



}
