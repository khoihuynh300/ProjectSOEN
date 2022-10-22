package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product", indexes = @Index(name = "sorted_price", columnList = "Price DESC"))
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pid;

	@ManyToOne
	@JoinColumn(name = "Ptype", nullable = false)
	private ProductType Ptype;

	@Column(nullable = false)
	private String Pname;

	@Column(nullable = false)
	private double Price;

	@Column(nullable = false)
	private String Description;

	@Column(name = "Quantity", nullable = false)
	private int Quantity;

	@ManyToOne
	@JoinColumn(name = "DiscountId", nullable = true)
	private Discount DiscountId;

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	@Column(name = "pin", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean pin;

	@OneToOne
	@JoinColumn(name = "image", nullable = true)
	private Image image;

	@Column(nullable = false)
	private String waranty;

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public boolean isPin() {
		return pin;
	}

	public void setPin(boolean pin) {
		this.pin = pin;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getWaranty() {
		return waranty;
	}

	public void setWaranty(String waranty) {
		this.waranty = waranty;
	}

}
