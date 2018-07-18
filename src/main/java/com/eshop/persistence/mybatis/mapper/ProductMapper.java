package com.eshop.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.eshop.biz.entity.Product;


public interface ProductMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id") //回写自增的主键ID
	@Insert("insert into product (product_code,product_name) values(#{product_code},#{product_name})")
	public Integer addProduct(Product product);
	
	//@Select("select * from client where id=#{0}")
	public Product getById(Integer id);
}
