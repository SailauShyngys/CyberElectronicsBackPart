package com.example.cyberelectronicsback.repository;

import com.example.cyberelectronicsback.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}