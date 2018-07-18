package com.eshop.biz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@Entity()
@Table(name="order_item")
public class OrderItem {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Transient
	private Long orderId; //No Needed for JPA
	
	private String productCode;
	private double price;
	

}
