package com.eshop.persistence.jpa.service;

import org.springframework.data.repository.CrudRepository;
import com.eshop.biz.entity.Product;

public interface JpaProductRepositoryService extends CrudRepository<Product, Long>  {

}
