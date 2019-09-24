package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@ManagedBean(name="orders")
public class Order implements Serializable {

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

    @Override
    public String toString() {
        return "Order: " +
                "id=" + id +
                ", nameCustomer='" + nameCustomer +
                ", addressCustomer='" + addressCustomer +
                ", sumOrder=" + sumOrder +
                ", dateCreation=" + dateCreation;
    }
}
