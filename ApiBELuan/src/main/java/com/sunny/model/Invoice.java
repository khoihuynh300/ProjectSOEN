package com.sunny.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "Invoice")

@JsonPropertyOrder({ "invoiceId", "cusomerName", "orderId","total", "paymentMethod","creationDate", "payDate"})
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InvoiceId;

	@OneToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId", nullable = false)
	private Orders OrderId;

	@Column(nullable = false)
	private String CusomerName;

	@ManyToOne
	@JoinColumn(name = "PaymentMethod", nullable = false)
	private PaymentMethod PaymentMethod;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date CreationDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date PayDate;

	@Column(nullable = false)
	private double Total;

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

	public PaymentMethod getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		PaymentMethod = paymentMethod;
	}

	public Date getPayDate() {
		return PayDate;
	}

	public void setPayDate(Date payDate) {
		PayDate = payDate;
	}

}
