package com.eshop.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eshop.biz.entity.Order;
import com.eshop.biz.entity.OrderItem;
import com.eshop.persistence.jpa.service.JpaOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTester {
	@Resource
	JpaOrderService jpaService;
	
	@Test
	public void testAddOrder() {
		Assert.assertNotNull(jpaService);
		
		Order order = (new Order()).setStatus("S").setOrderDate(new Date()).setOrderAmount(1000);
		order.getItems().add(new OrderItem().setProductCode("A0001").setPrice(10.00));
		
		jpaService.addOrder(order);
		
		order = jpaService.getById(1L);
		System.out.println("order="+order);
		Assert.assertNotNull(order);
	}
}
