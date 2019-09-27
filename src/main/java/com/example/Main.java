package com.example;

import com.example.entity.Product;
import com.example.service.OrderDetailsService;
import com.example.service.impl.OrderDetailsServiceImpl;
import com.example.unmarshal.UnMarshalProduct;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDetailsServiceImpl orderDetailsService = new OrderDetailsServiceImpl();
//        Order newOr = new Order();
//        newOr.setId(4);
//        newOr.setNameCustomer("Samsung Group");
//        newOr.setAddressCustomer("Republic of Korea, Suwon");
//        newOr.setSumOrder(56);

//        System.out.println(orderDetailsService.updateOrder(newOr));

//        UnMarshalProduct unMarshalProduct = new UnMarshalProduct();
//        System.out.println(unMarshalProduct.getUnMarshal());

//        List<Product> productList =  orderDetailsService.getProductFromXML();
//        for (Product product : productList) {
//            System.out.println(product);
//        }
        orderDetailsService.getProductFromXML();
    }
}
