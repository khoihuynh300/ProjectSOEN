package com.sunny.model;

import javax.persistence.Column;
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
	@JoinColumn(name = "InvoiceId", nullable = false)
	private Invoice InvoiceId;

	@OneToOne
	@JoinColumn(name = "OrderDetailId", referencedColumnName = "Id", nullable = false)
	private OrderDetail OrderDetailId;

	@Column(nullable = false)
	private int Quantity;

	@Column(nullable = false)
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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

}
