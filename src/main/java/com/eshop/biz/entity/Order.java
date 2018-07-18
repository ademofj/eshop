package com.eshop.biz.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@Entity()
@Table(name="client_order")
public class Order {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String status;
	private Date orderDate;
	private double orderAmount;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval=true)
    @JoinColumn(name = "order_id", updatable = true, insertable = true)
    private Set<OrderItem> items;
	
	public Set<OrderItem> getItems() {
		if(items == null) {
			items = new HashSet<OrderItem>();
		}
		return items;
	}
}
