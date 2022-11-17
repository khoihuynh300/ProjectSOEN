package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "OrderDetail", indexes = @Index(name = "index_orderid", columnList = "OrderId"))
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "OrderId", nullable = false)
	private Orders OrderId;

	@ManyToOne
	@JoinColumn(name = "Pid", nullable = false)
	private Product ProductId;

	@Column(nullable = false)
	private double Price;

	@Column(nullable = false)
	private int Quantity;

	@Column(nullable = false)
	private double Discount;

	@Column(nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean status;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
