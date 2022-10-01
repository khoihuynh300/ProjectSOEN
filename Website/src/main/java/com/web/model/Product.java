package com.web.model;

public class Product {
	private int Pid;
	private int Ptype;
	private String Pname;
	private double Price;
	private String Description;
	private int DiscountId;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public int getPtype() {
		return Ptype;
	}
	public void setPtype(int ptype) {
		Ptype = ptype;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getDiscountId() {
		return DiscountId;
	}
	public void setDiscountId(int discountId) {
		DiscountId = discountId;
	}
	
	
}
