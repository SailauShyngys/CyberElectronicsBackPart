package com.example.cyberelectronicsback.service.impl;

import org.springframework.stereotype.Service;
import com.example.cyberelectronicsback.model.Category;
import com.example.cyberelectronicsback.repository.CategoryRepository;
import com.example.cyberelectronicsback.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return categoryRepository.save(category).getId();
    }

    @Override
    public Category updateCategory(Long id, String name, String description) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(name);
        category.setDescription(description);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}