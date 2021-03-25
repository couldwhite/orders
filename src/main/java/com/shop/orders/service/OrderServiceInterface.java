package com.shop.orders.service;

import com.shop.orders.domain.Orders;

import java.util.List;

public interface OrderServiceInterface {

    Orders getById(Long id);

    void save (Orders orders);

    void delete (Long id);

    List<Orders> getOrders ();
}
