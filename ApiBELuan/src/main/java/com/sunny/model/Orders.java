package com.sunny.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "Orders", indexes = @Index(name = "sorted_date", columnList = "OrderDate ASC"))

@JsonPropertyOrder({ "orderId", "cusId", "OrderDate","status","ShipedDate","paymentMethod","shipAddress","note", "shipId" })
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;

	@ManyToOne
	@JoinColumn(name = "CusId", nullable = false)
	private Customer CusId;

	@ManyToOne
	@JoinColumn(name = "EmpId")
	private Employee ShipId;

	@Column(name = "Status", nullable = false, columnDefinition = "int default 0")
	private int Status;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date OrderDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date ShipedDate;

	@Column(nullable = false)
	private String ShipAddress;

	@ManyToOne
	@JoinColumn(name = "Id")
	private PaymentMethod PaymentMethod;

	private String note;

	public int getOrderId() {
		return OrderId;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Date getShipedDate() {
		return ShipedDate;
	}

	public void setShipedDate(Date shipedDate) {
		ShipedDate = shipedDate;
	}

	public String getShipAddress() {
		return ShipAddress;
	}

	public void setShipAddress(String shipAddress) {
		ShipAddress = shipAddress;
	}

	public Customer getCusId() {
		return CusId;
	}

	public void setCusId(Customer cusId) {
		CusId = cusId;
	}

	public Employee getShipId() {
		return ShipId;
	}

	public void setShipId(Employee shipId) {
		ShipId = shipId;
	}

	public PaymentMethod getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		PaymentMethod = paymentMethod;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
