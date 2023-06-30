package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.CategoryCreateDto;
import com.example.cyberelectronicsback.model.Category;
import com.example.cyberelectronicsback.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/api/categories/{id}")
    public Category getById(@PathVariable Long id) throws Exception {
        return categoryService.getById(id);
    }

    @PostMapping("/api/categories")
    public Long createCategoty(@RequestBody CategoryCreateDto createDto) {
        return categoryService.createCategory(createDto.getName(), createDto.getDescription());
    }

    @PutMapping("/api/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody CategoryCreateDto createDto) throws Exception {
        return categoryService.updateCategory(id, createDto.getName(), createDto.getDescription());
    }

    @DeleteMapping("/api/categories/{id}")
    public void deleteCategory(@PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
    }
}