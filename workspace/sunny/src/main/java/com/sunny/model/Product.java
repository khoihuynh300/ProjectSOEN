package com.sunny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pid;

	@ManyToOne
	@JoinColumn(name = "Ptype")
	private ProductType Ptype;
	private String Pname;
	private double Price;
	private String Description;

	@ManyToOne
	@JoinColumn(name = "DiscountId")
	private Discount DiscountId;

	public void setPid(int pid) {
		Pid = pid;
	}

	public int getPid() {
		return Pid;
	}

	public ProductType getPtype() {
		return Ptype;
	}

	public void setPtype(ProductType ptype) {
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

	public Discount getDiscountId() {
		return DiscountId;
	}

	public void setDiscountId(Discount discountId) {
		DiscountId = discountId;
	}

}
