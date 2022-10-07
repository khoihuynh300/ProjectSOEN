package com.sunny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InvoiceItem")
public class InvoiceItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "InvoiceId")
	private Invoice InvoiceId;

	@OneToOne
	@JoinColumn(name = "OrderDetailId", referencedColumnName = "Id")
	private OrderDetail OrderDetailId;
	private int Amount;
	private double Price;

	public Invoice getInvoiceId() {
		return InvoiceId;
	}

	public void setInvoiceId(Invoice invoiceId) {
		InvoiceId = invoiceId;
	}

	public OrderDetail getOrderDetailId() {
		return OrderDetailId;
	}

	public void setOrderDetailId(OrderDetail orderDetailId) {
		OrderDetailId = orderDetailId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

}
