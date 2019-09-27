package com.example.entity;

import com.example.service.impl.OrderDetailsServiceImpl;
import com.example.utils.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@ManagedBean(name = "product")
@XmlRootElement(name = "product")
@SessionScoped
@FacesValidator("productValidator")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable, Validator {

    public static OrderDetailsServiceImpl ods;

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @XmlJavaTypeAdapter(DateAdapter.class)
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
        dateProduct = product.getDateProduct();
        return product;
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object obj)
            throws ValidatorException {
        Integer model = (Integer) obj;
        ods = new OrderDetailsServiceImpl();
        if (ods.findProductById(model) == null) {
            FacesMessage msg = new FacesMessage(
                    "There is no such product. Please, enter the correct number.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
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
