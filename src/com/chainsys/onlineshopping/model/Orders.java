package com.chainsys.onlineshopping.model;

import java.time.LocalDate;

public class Orders {
	private int id;
	private Product productId;
	private	int quantity;
	private	int orderNo;
	private LocalDate orderedDate;
	private Registration registerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	
	public Registration getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Registration registerId) {
		this.registerId = registerId;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", productId=" + productId + ", quantity="
				+ quantity + ", orderNo=" + orderNo + ", orderedDate="
				+ orderedDate + ", register=" + registerId + "]";
	}

}
