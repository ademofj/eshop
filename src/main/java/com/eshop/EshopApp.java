package com.eshop;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.eshop.biz.entity.Order;
import com.eshop.biz.entity.OrderItem;
import com.eshop.biz.entity.Product;
import com.eshop.persistence.jpa.service.JpaOrderRepositoryService;
import com.eshop.persistence.jpa.service.JpaOrderService;
import com.eshop.persistence.jpa.service.JpaProductService;
import com.eshop.persistence.mybatis.service.MybatisOrderService;
import com.eshop.persistence.mybatis.service.MybatisSqlService;

/**
 * References:
 *   - h2
 *     https://blog.csdn.net/mn960mn/article/details/54644908
 *     
 * @author Sky zhang
 *
 */
@SpringBootApplication
public class EshopApp {
	public static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Throwable {
		boolean isWebApp = true;
		isWebApp = false;
		
		ctx = new SpringApplicationBuilder(EshopApp.class).web(isWebApp).run(args);
		
 		showContext();

  		jpa();
 		repository();
		
		mybatis();
		
 		sql();
	}
	
	private static void showContext() throws Throwable {
		String[] beanNames = ctx.getBeanDefinitionNames();
		
		for(String beanName : beanNames) {
			System.out.println("beanName = "+beanName);
		}
	}
	
	private static void jpa() throws Throwable {
		System.out.println("JPA...");
		
		Order order = null;
		JpaOrderService jpaService = ctx.getBean(JpaOrderService.class);
		
		order = (new Order()).setStatus("S").setOrderDate(new Date()).setOrderAmount(1000);
		
	
		
		order.getItems().add(new OrderItem().setProductCode("A0001").setPrice(10.00));
		jpaService.addOrder(order);
//		System.out.println("order="+order);
		System.out.println("all.size="+jpaService.all().size());
		System.out.println("all="+jpaService.all());
		
		order = jpaService.getById(1L);
		System.out.println("order="+order);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(order);
		System.out.println("json="+json);

	}
	
	private static void repository() throws Throwable {
		System.out.println("JPA Repository Service ...");
		
		Order order = null;
		JpaOrderRepositoryService jpaOrderRepositoryService = ctx.getBean(JpaOrderRepositoryService.class);
		System.out.println("jpaOrderRepositoryService="+jpaOrderRepositoryService);
		order = jpaOrderRepositoryService.save(new Order().setStatus("S").setOrderDate(new Date()).setOrderAmount(1000));
		System.out.println("order@repository="+order);
		
		order = jpaOrderRepositoryService.findOne(1L);
		System.out.println("order@repository="+order);
	}
	
	private static void mybatis() throws Throwable {
		System.out.println("Mybatis...");
		Order order = null;
		MybatisOrderService mybatisService = ctx.getBean(MybatisOrderService.class);
		
		
		
		order = new Order().setStatus("S").setOrderDate(new Date()).setOrderAmount(1000);
		order.getItems().add(new OrderItem().setProductCode("A0001").setPrice(10.00));
		Integer newId = mybatisService.addOrder(order);
		System.out.println("newId:"+newId);
		System.out.println("newOrder:"+order);
		
		order = mybatisService.getById(2);
	 	System.out.println("order="+order);
//		
//		order = mybatisService.getById(2);
//		System.out.println("order[2]="+order);
	}
	
	private static void sql() throws Throwable {
		/*
		 * Prepare Data
		 */
		JpaOrderService jpaService = ctx.getBean(JpaOrderService.class);
		Order order = (new Order()).setStatus("S").setOrderDate(new Date()).setOrderAmount(1000);
		
		order.getItems().add(new OrderItem().setProductCode("A0001").setPrice(10.00));
		jpaService.addOrder(order);
		order = (new Order()).setStatus("M").setOrderDate(new Date()).setOrderAmount(2000);
		order.getItems().add(new OrderItem().setProductCode("A0002").setPrice(20.00));
		jpaService.addOrder(order);
		
		
		JpaProductService jpaProductService = ctx.getBean(JpaProductService.class);
		Product product = (new Product()).setProductCode("A0001").setProductName("Shoe A");
		jpaProductService.addProduct(product);
		
		product = (new Product()).setProductCode("A0002").setProductName("Shoe B");
		jpaProductService.addProduct(product);
		
		/*
		 * SQL Query
		 */
		MybatisSqlService mybatisSqlService = ctx.getBean(MybatisSqlService.class);
		List list = mybatisSqlService.query();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println("json="+json);
	}
}
