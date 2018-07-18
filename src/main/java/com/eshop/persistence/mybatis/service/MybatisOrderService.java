package com.eshop.persistence.mybatis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eshop.biz.entity.Order;
import com.eshop.biz.entity.OrderItem;
import com.eshop.persistence.mybatis.mapper.OrderItemMapper;
import com.eshop.persistence.mybatis.mapper.OrderMapper;

@Service
public class MybatisOrderService {
	@Resource
	OrderMapper orderMapper;
	
	@Resource
	OrderItemMapper orderItemMapper;
	
	public Integer addOrder(Order order) {
		Integer result = orderMapper.addOrder(order);
		for(OrderItem orderItem : order.getItems()) {
			orderItem.setOrderId(order.getId());
			orderItemMapper.addOrderItem(orderItem);
		}
		return result; 
	}
	
	public Order getById(Integer orderId) {
		return orderMapper.getById(orderId);
	}
}
