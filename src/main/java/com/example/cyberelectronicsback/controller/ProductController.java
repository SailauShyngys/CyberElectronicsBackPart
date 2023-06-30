package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.ProductCreateDto;
import com.example.cyberelectronicsback.model.Product;
import com.example.cyberelectronicsback.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/products/{id}")
    public Product getById(@PathVariable Long id) throws Exception {
        return productService.getById(id);
    }

    @GetMapping("/api/product/{id}")
    public List<Product> getByIdProduct(@PathVariable List<Long> id) throws Exception {
        return productService.getByIdProduct(id);
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductCreateDto createDto) throws Exception {
        return productService.createProduct(createDto);
    }

    @PutMapping("/api/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductCreateDto createDto) throws Exception {
        return productService.updateProduct(id, createDto);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
    }

}