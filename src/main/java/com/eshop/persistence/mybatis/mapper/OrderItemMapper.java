package com.eshop.persistence.mybatis.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.eshop.biz.entity.OrderItem;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Sky zhang
 * @since 2018-07-16
 */
//public interface ClientIdentityMapper extends BaseMapper<ClientContact> {
public interface OrderItemMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id") //回写自增的主键ID
	@Insert("insert into order_item (order_id,product_code,price) values(#{orderId}, #{productCode}, #{price})")
	public Integer addOrderItem(OrderItem orderItem);
	
	//@Select("select * from order_item where order_id=#{orderId}")
	List<OrderItem> listByOrderId(@Param("orderId") Serializable orderId);
}
