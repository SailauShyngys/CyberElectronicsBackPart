package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.model.Category;

public interface CategoryService {
    Category getById(Long id) throws Exception;

    Long createCategory(String name, String description);

    Category updateCategory(Long id, String name, String description);

    void deleteCategory(Long id) throws Exception;
}