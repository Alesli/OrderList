package com.example.entity;

import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Setter
@ManagedBean(name = "beanDate")
// Помещает управляемый bean-компонент в область видимости сеанса.
@SessionScoped
public class BeanDate implements Serializable {

    private String date;

}
