package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.OrderCreateDto;
import com.example.cyberelectronicsback.model.Order;
import com.example.cyberelectronicsback.service.OrderService;
import com.example.cyberelectronicsback.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    public final OrderRepository orderRepository;

    @GetMapping("/api/orders/{id}")
    public Order getById(@PathVariable Long id) throws Exception {
        return orderService.getById(id);
    }

    @GetMapping("/api/order")
    public List<Order> getByAll() throws Exception {
        return orderService.getByAll();
    }

    @PostMapping("/api/order")
    public Order createOrder(@RequestBody OrderCreateDto createDto) throws Exception {
        return orderService.createOrder(createDto.getProductId());
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
        orderService.deleteOrder(id);
    }

}
