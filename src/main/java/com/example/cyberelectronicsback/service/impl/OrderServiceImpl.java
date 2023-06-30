package com.example.cyberelectronicsback.service.impl;

import com.example.cyberelectronicsback.model.Order;
import com.example.cyberelectronicsback.model.Product;
import com.example.cyberelectronicsback.repository.OrderRepository;
import com.example.cyberelectronicsback.service.OrderService;
import com.example.cyberelectronicsback.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final ProductService productService;


    @Override
    public Order getById(Long id) throws Exception {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getByAll() throws Exception {
        return orderRepository.findAll().stream().toList();
    }

    @Override
    public Order createOrder(List<Long> ids) throws Exception {
        Order order = new Order();
        List<Product> product = new ArrayList<>();

        for (Long in : ids) {
            product.add(productService.getById(in));
        }

        int sum = orderSum(product);

        order.setOrderProduct(product);
        order.setSum(sum);

        return orderRepository.save(order);
    }

    private int orderSum(List<Product> products) {
        int sum = 0;

        for (Product product : products) {
            sum += product.getPrice() * product.getQuantity();
        }

        return sum;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}