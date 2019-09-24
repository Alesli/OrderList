package com.example.entity;

import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Setter
@ManagedBean(name = "beanDate")
// Помещает управляемый bean-компонент в область видимости сеанса.
@SessionScoped
public class BeanDate {

    private String date;
}
