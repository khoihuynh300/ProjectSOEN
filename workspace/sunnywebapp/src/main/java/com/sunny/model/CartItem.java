package com.sunny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CartItem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "CartId")
	private Cart CartId;

	@ManyToOne
	@JoinColumn(name = "Pid")
	private Product ProductId;
	private double Price;
	private int Quantity;
	private double Discount;

	public Cart getCartId() {
		return CartId;
	}

	public void setCartId(Cart cartId) {
		CartId = cartId;
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
