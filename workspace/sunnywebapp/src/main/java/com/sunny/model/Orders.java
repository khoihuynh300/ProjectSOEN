package com.sunny.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;

	@ManyToOne
	@JoinColumn(name = "CusId")
	private Customer CusId;

	@ManyToOne
	@JoinColumn(name = "EmpId")
	private Employee ShipId;
	private int Status;
	private Date OrderDate;
	private Date ShipedDate;
	private String ShipAddress;

	@ManyToOne
	@JoinColumn(name = "Id")
	private PaymentMethod PaymentMethod;

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

}
