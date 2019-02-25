package com.chainsys.onlineshopping.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Product {

	private int id;
	private Category categoryId;
	private String product;
	private String description;
	private int quantity;
	private int price;
	private LocalDate expiredDate;
	private Timestamp createdDate;
	private String status;

	public int getId() {
		return id;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId
				+ ", product=" + product + ", description=" + description
				+ ", quantity=" + quantity + ", price=" + price
				+ ", expiredDate=" + expiredDate + ", createdDate="
				+ createdDate + ", status=" + status + "]";
	}


}
