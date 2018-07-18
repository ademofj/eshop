package com.eshop.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.eshop.biz.entity.Order;


public interface OrderMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id") //回写自增的主键ID
	@Insert("insert into client_order (status,order_date,order_amount) values(#{status},#{orderDate},#{orderAmount})")
	public Integer addOrder(Order order);
	
	//@Select("select * from client_order where id=#{id}")
	public Order getById(Integer id);
}
