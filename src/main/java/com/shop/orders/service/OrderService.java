package com.shop.orders.service;

import com.shop.orders.domain.Orders;
import com.shop.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceInterface{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Orders getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }
}
