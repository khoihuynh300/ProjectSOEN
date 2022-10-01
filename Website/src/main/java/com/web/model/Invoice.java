package com.web.model;

import java.util.Date;

public class Invoice {
	private int InvoiceId;
	private int OrderId;
	private String CusomerName;
	private int PaymentMethod;
	private Date CreationDate;
	private double Total;
	private boolean Status;
	public int getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		InvoiceId = invoiceId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getCusomerName() {
		return CusomerName;
	}
	public void setCusomerName(String cusomerName) {
		CusomerName = cusomerName;
	}
	public int getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	
}
