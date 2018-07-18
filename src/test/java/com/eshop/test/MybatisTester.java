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

import com.eshop.persistence.mybatis.service.MybatisOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTester {
	@Resource
	MybatisOrderService mybatisService;
	
	@Test
	public void testAddOrder() {
		Assert.assertNotNull(mybatisService);
		
		Order order = mybatisService.getById(1);
		Assert.assertNull(order);
		
		order = (new Order()).setStatus("S").setOrderDate(new Date()).setOrderAmount(1000);
		mybatisService.addOrder(order);
		order = mybatisService.getById(1);
		Assert.assertNotNull(order);
	}
}
