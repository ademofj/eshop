package com.eshop.persistence.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eshop.biz.entity.Order;

@Service
@Transactional
public class JpaOrderService {
	@PersistenceContext
	EntityManager entityManager;
	
	public Order addOrder(Order order) {
		entityManager.persist(order);
		
		return order;
	}
	
	public Order getById(Long orderId) {
		return entityManager.find(Order.class, orderId);
	}
	
	public List<Order> all() {
		Query query = entityManager.createQuery("from Order");
		return query.getResultList();
	}
}
