package com.sunny.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ItemId")
	private int itemID;

	@ManyToOne
	@JoinColumn(name = "ItemType")
	private ItemType itemType;

	@ManyToOne
	@JoinColumn(name = "Brand")
	private Brand brand;

	@Column(name = "ItemName")
	private String itemName;

	@Column(name = "Price")
	private float price;

	@Column(name = "Description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "Discount")
	private Discount discount;

	@Column(name = "TimeStartSales")
	private java.util.Date timeStartSales;

	@Column(name = "TimeEndSales")
	private java.util.Date timeEndSales;

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public java.util.Date getTimeStartSales() {
		return timeStartSales;
	}

	public void setTimeStartSales(java.util.Date timeStartSales) {
		this.timeStartSales = timeStartSales;
	}

	public java.util.Date getTimeEndSales() {
		return timeEndSales;
	}

	public void setTimeEndSales(java.util.Date timeEndSales) {
		this.timeEndSales = timeEndSales;
	}

	public int getItemID() {
		return itemID;
	}

}
