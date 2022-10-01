package com.web.model;

import java.util.Date;

public class Order {
	private int OrderId;
	private int CusId;
	private int EmpId;
	private int ShipId;
	private int Status;
	private Date OrderDate;
	private Date ShipedDate;
	private String ShipAddress;
	private int PaymentMethod;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getCusId() {
		return CusId;
	}
	public void setCusId(int cusId) {
		CusId = cusId;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public int getShipId() {
		return ShipId;
	}
	public void setShipId(int shipId) {
		ShipId = shipId;
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
	public int getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	
	
}
