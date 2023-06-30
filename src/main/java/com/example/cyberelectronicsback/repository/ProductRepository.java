package com.example.cyberelectronicsback.repository;

import com.example.cyberelectronicsback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
