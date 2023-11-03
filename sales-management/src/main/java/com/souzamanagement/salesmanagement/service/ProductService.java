package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.CategoryDto;
import com.souzamanagement.salesmanagement.dto.ProductDto;
import com.souzamanagement.salesmanagement.entity.CategoryModel;
import com.souzamanagement.salesmanagement.entity.ProductModel;
import com.souzamanagement.salesmanagement.exception.AlreadyExistsException;
import com.souzamanagement.salesmanagement.exception.NotFoundException;
import com.souzamanagement.salesmanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> getProducts() {
        var products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

    public ProductDto getProductByCode(Long code) {
        var product = productRepository.findByCode(code);
        if(product == null) {
            throw new NotFoundException("Product with code " + code + " not found");
        }
        return modelMapper.map(product, ProductDto.class);
    }

    public ProductDto postProduct(ProductDto dto) {
        var existsByName = productRepository.existsByDescription(dto.getDescription());
        if(existsByName) {
            throw new AlreadyExistsException("Description already exists");
        }
        var product = modelMapper.map(dto, ProductModel.class);
        var savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    public ProductDto putProduct(ProductDto dto, Long code) {
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
        return modelMapper.map(product, ProductDto.class);
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
