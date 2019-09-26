package com.example.entity;

import com.example.service.impl.OrderDetailsServiceImpl;
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
@Table(name = "product")
@ManagedBean(name = "product")
public class Product implements Serializable {

    public static OrderDetailsServiceImpl ods;

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "serial_number")
    private String serialNumber;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "date_production")
    private Date dateProduct;

    public void updateProductDetails() {
        ods = new OrderDetailsServiceImpl();
        ods.updateProduct(this);
    }

    public Product getProductById() {
        ods = new OrderDetailsServiceImpl();
        Product product = ods.findProductById(id);
        serialNumber = product.getSerialNumber();
        name = product.getName();
        description = product.getDescription();

        return product;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id = " + id +
                ", serialNumber = " + serialNumber +
                ", name = " + name +
                ", description = " + description +
                ", dateProduct = " + dateProduct;
    }
}
