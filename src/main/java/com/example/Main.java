package com.example;

import com.example.entity.Order;
import com.example.service.OrderDetailsService;
import com.example.service.impl.OrderDetailsServiceImpl;

public class Main {
    public static void main(String[] args) {
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
        Order newOr = new Order();
        newOr.setId(4);
        newOr.setNameCustomer("Samsung Group");
        newOr.setAddressCustomer("Republic of Korea, Suwon");
        newOr.setSumOrder(56);

//        System.out.println(orderDetailsService.updateOrder(newOr));
    }
}
