package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
@ManagedBean(name="orderDetail")
public class OrderDetails implements Serializable {

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private Product product;

    @Basic
    @Column(name = "quantity")
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @Override
    public String toString() {
        return "OrderDetails: " +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", order=" + order;
    }
}
