package com.sunny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Orders OrderId;

	@ManyToOne
	@JoinColumn(name = "Pid")
	private Product ProductId;
	private double Price;
	private int Quantity;
	private double Discount;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Orders getOrderId() {
		return OrderId;
	}

	public void setOrderId(Orders orderId) {
		OrderId = orderId;
	}

	public Product getProductId() {
		return ProductId;
	}

	public void setProductId(Product productId) {
		ProductId = productId;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

}
