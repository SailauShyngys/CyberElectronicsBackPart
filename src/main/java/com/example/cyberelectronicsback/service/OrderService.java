package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.model.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id) throws Exception;

    List<Order> getByAll() throws Exception;

    Order createOrder(List<Long> id) throws Exception;

    void deleteOrder(Long id) throws Exception;
}
