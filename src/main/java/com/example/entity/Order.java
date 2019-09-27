package com.example.entity;

import com.example.service.impl.OrderDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
@ManagedBean(name = "order")
@SessionScoped
@FacesValidator("orderValidator")
public class Order implements Serializable, Validator {

    public static OrderDetailsServiceImpl ods;

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name_customer")
    private String nameCustomer;

    @Basic
    @Column(name = "address_customer")
    private String addressCustomer;

    @Basic
    @Column(name = "sum_order")
    private Integer sumOrder;

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
        dateCreation = order.getDateCreation();
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

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object obj)
            throws ValidatorException {
        Integer model = (Integer) obj;
        ods = new OrderDetailsServiceImpl();
        if (ods.findOrderById(model) == null) {
            FacesMessage msg = new FacesMessage(
                    "There is no such order. Please, enter the correct number.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }
}
