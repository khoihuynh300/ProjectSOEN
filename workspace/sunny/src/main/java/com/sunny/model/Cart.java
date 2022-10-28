package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	@ManyToOne
	@JoinColumn(name = "CusId", nullable = false)
	private Customer CusId;

	@Column(columnDefinition = "int default 0", nullable = false)
	private int amountUniqueItem;

	public Customer getCusId() {
		return CusId;
	}

	public void setCusId(Customer cusId) {
		CusId = cusId;
	}

	public int getAmountUniqueItem() {
		return amountUniqueItem;
	}

	public void setAmountUniqueItem(int amountUniqueItem) {
		this.amountUniqueItem = amountUniqueItem;
	}

}
