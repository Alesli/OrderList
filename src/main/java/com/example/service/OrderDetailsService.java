package com.example.service;

import com.example.entity.Order;
import com.example.entity.OrderDetails;
import com.example.entity.Product;

import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> findAll();

    List<Product> findAllProducts();

    Order findOrderById(Integer id);

    Product findProductById(Integer id);

    void updateOrder(Order newOrder);

    void updateProduct(Product newProduct);

    Order saveOrder(Order order);

    Product saveGood(Product product);
}
