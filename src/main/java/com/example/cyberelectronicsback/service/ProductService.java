package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.controller.dto.ProductCreateDto;
import com.example.cyberelectronicsback.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id) throws Exception;

    List<Product> getByIdProduct(List<Long> id) throws Exception;

    Product createProduct(ProductCreateDto createDto) throws Exception;

    void deleteProduct(Long id) throws Exception;

    Product updateProduct(Long id, ProductCreateDto createDto) throws Exception;
}