package com.web.model;

public class InvoiceItem {
	private int InvoiceId;
	private int OrderDetailId;
	private int Amount;
	private double Price;
	public int getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		InvoiceId = invoiceId;
	}
	public int getOrderDetailId() {
		return OrderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
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
