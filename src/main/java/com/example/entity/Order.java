package com.example.entity;

import com.example.service.impl.OrderDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
@ManagedBean(name = "order")
public class Order implements Serializable {

    public static OrderDetailsServiceImpl ods;

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name_customer")
    private String nameCustomer;

    @Basic
    @Column(name = "address_customer")
    private String addressCustomer;

    @Basic
    @Column(name = "sum_order")
    private int sumOrder;

    @Basic
    @Column(name = "date_creation")
    private Date dateCreation;


    public void updateOrderDetails() {
        ods = new OrderDetailsServiceImpl();
        ods.updateOrder(this);
    }

    public Order getOderById() {
        ods = new OrderDetailsServiceImpl();
        Order order = ods.findOrderById(id);
        nameCustomer = order.getNameCustomer();
        addressCustomer = order.getAddressCustomer();
        sumOrder = order.getSumOrder();
        return order;
    }

    @Override
    public String toString() {
        return "Order: " +
                "id = " + id +
                ", nameCustomer = " + nameCustomer +
                ", addressCustomer='" + addressCustomer +
                ", sumOrder = " + sumOrder +
                ", dateCreation = " + dateCreation;
    }
}
