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

@Entity
@Table(name = "CartItem", indexes = @Index(name = "cartid", columnList = "CartId"))
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "CartId", nullable = false)
	private Cart CartId;

	@ManyToOne
	@JoinColumn(name = "Pid", nullable = false)
	private Product ProductId;

	@Column(nullable = false)
	private int Quantity;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
