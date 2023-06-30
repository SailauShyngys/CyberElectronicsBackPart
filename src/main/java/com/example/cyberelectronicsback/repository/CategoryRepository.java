package com.example.cyberelectronicsback.repository;

import com.example.cyberelectronicsback.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
