package com.example.service.impl;

import com.example.entity.Order;
import com.example.entity.OrderDetails;
import com.example.entity.Product;
import com.example.jpa.JpaUtil;
import com.example.service.OrderDetailsService;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private EntityManager entityManager = JpaUtil.getEntityManager();

    @Override
    public List<OrderDetails> findAll() {
        String str = "SELECT od from OrderDetails od";
        TypedQuery<OrderDetails> query =
                entityManager.createQuery(str, OrderDetails.class);
        return query.getResultList();
    }

    @Override
    public Order findOrderById(int id) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("findOrderById", id);
        return entityManager.find(Order.class, id);
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void updateOrder(Order newOrder) {
        if (newOrder.getId() != 0) {
            entityManager.detach(newOrder);
            newOrder.setNameCustomer(newOrder.getNameCustomer());
            newOrder.setSumOrder(newOrder.getSumOrder());
            newOrder.setAddressCustomer(newOrder.getAddressCustomer());
            newOrder.setDateCreation(newOrder.getDateCreation());
            entityManager.getTransaction().begin();
            entityManager.merge(newOrder);
            entityManager.getTransaction().commit();

        } else saveOrder(newOrder);
    }

    @Override
    public void updateProduct(Product newProduct) {
        if (newProduct.getId() != 0) {
            entityManager.detach(newProduct);
            newProduct.setName(newProduct.getName());
            newProduct.setSerialNumber(newProduct.getSerialNumber());
            newProduct.setDescription(newProduct.getDescription());
            newProduct.setDateProduct(newProduct.getDateProduct());
            entityManager.getTransaction().begin();
            entityManager.merge(newProduct);
            entityManager.getTransaction().commit();

        } else saveProduct(newProduct);
    }

    @Override
    public Order saveOrder(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Product saveProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }
}
