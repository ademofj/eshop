package com.eshop.persistence.jpa.service;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eshop.biz.entity.Product;

@Service
@Transactional
public class JpaProductService {
	@PersistenceContext
	EntityManager entityManager;
	
	public Product addProduct(Product product) {
		entityManager.persist(product);
		
		return product;
	}
	
}
