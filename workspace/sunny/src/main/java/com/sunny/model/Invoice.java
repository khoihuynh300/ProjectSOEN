package com.sunny.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InvoiceId;

	@OneToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
	private Orders OrderId;
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

	public Orders getOrderId() {
		return OrderId;
	}

	public void setOrderId(Orders orderId) {
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
