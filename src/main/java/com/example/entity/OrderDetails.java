package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
@ManagedBean(name="order_detail")
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

//    @Basic
//    @Column(name = "id_order")
//    private int idOrder;

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
