package com.eshop.persistence.jpa.service;

import org.springframework.data.repository.CrudRepository;

import com.eshop.biz.entity.Order;

public interface JpaOrderRepositoryService extends CrudRepository<Order, Long>  {

}
