package com.example.service.impl;

import com.example.entity.OrderDetails;
import com.example.jpa.JpaUtil;
import com.example.service.OrderDetailsService;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ManagedBean(name = "orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private EntityManager entityManager = JpaUtil.getEntityManager();

    @Override
    @Transactional
    public List<OrderDetails> findAll() {

        String str = "SELECT od from OrderDetails od";
        TypedQuery<OrderDetails> query =
                entityManager.createQuery(str, OrderDetails.class);
        return query.getResultList();
    }
}
