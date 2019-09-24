package com.example.entity;

import lombok.*;

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
@ManagedBean(name="product")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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

    @Override
    public String toString() {
        return "Product: " +
                "id='" + id +
                ", serialNumber='" + serialNumber +
                ", name='" + name +
                ", description='" + description +
                ", dateProduct=" + dateProduct;
    }
}
