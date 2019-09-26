package com.example.service;

import com.example.entity.Order;
import com.example.entity.OrderDetails;
import com.example.entity.Product;

import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> findAll();

    Order findOrderById(int id);

    Product findProductById(int id);

    void updateOrder(Order newOrder);

    void updateProduct(Product newProduct);

    Order saveOrder(Order order);

    Product saveProduct(Product product);
}
