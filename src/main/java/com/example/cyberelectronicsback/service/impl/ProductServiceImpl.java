package com.example.cyberelectronicsback.service.impl;

import com.example.cyberelectronicsback.model.Product;
import com.example.cyberelectronicsback.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.cyberelectronicsback.controller.dto.ProductCreateDto;
import com.example.cyberelectronicsback.repository.ProductRepository;
import com.example.cyberelectronicsback.service.CategoryService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getByIdProduct(List<Long> id) {
        return productRepository.findAllById(id).stream().toList();
    }

    @Override
    public Product createProduct(ProductCreateDto createDto) throws Exception {
        Product product = new Product();
        product.setName(createDto.getName());
        product.setPrice(createDto.getPrice());
        product.setDescription(createDto.getDescription());
        product.setQuantity(createDto.getQuantity());
        product.setCategory(categoryService.getById(createDto.getCategoryId()));
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductCreateDto createDto) throws Exception {
        Product product = productRepository.findById(id).orElseThrow();
        if (id != null) {
            product.setName(createDto.getName());
            product.setPrice(createDto.getPrice());
            product.setDescription(createDto.getDescription());
            product.setQuantity(createDto.getQuantity());
            product.setCategory(categoryService.getById(createDto.getCategoryId()));
        }
        return productRepository.save(product);
    }
}