package com.example.service.impl;

import com.example.entity.Order;
import com.example.entity.OrderDetails;
import com.example.entity.Product;
import com.example.jpa.JpaUtil;
import com.example.service.OrderDetailsService;
import com.example.utils.UnMarshalProduct;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private EntityManager entityManager = JpaUtil.getEntityManager();
    private UnMarshalProduct unMarshalProduct = new UnMarshalProduct();

    @Override
    public List<OrderDetails> findAll() {
        String str = "SELECT od from OrderDetails od";
        TypedQuery<OrderDetails> query =
                entityManager.createQuery(str, OrderDetails.class);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllProducts() {
        String str = "SELECT p from Product p";
        TypedQuery<Product> query =
                entityManager.createQuery(str, Product.class);
        return query.getResultList();
    }

    @Override
    public Order findOrderById(Integer id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public Product findProductById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void updateOrder(Order newOrder) {
        if (newOrder.getId() != null) {
            entityManager.detach(newOrder);
            newOrder.setNameCustomer(newOrder.getNameCustomer());
            newOrder.setSumOrder(newOrder.getSumOrder());
            newOrder.setAddressCustomer(newOrder.getAddressCustomer());
            newOrder.setDateCreation(new Date());
            entityManager.getTransaction().begin();
            entityManager.merge(newOrder);
            entityManager.getTransaction().commit();

        } else saveOrder(newOrder);
    }

    @Override
    public void updateProduct(Product newProduct) {
        if (newProduct.getId() != null) {
            entityManager.detach(newProduct);
            newProduct.setName(newProduct.getName());
            newProduct.setSerialNumber(newProduct.getSerialNumber());
            newProduct.setDescription(newProduct.getDescription());
            newProduct.setDateProduct(new Date());
            entityManager.getTransaction().begin();
            entityManager.merge(newProduct);
            entityManager.getTransaction().commit();

        } else saveGood(newProduct);
    }

    @Override
    public Order saveOrder(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Product saveGood(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;

    }

    public void getProductFromXML() {
        Product product = unMarshalProduct.getProduct();
        saveGood(product);
    }
}
