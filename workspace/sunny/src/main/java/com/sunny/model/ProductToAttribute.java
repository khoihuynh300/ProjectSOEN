package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductToAttribute")
public class ProductToAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "Pid")
	private Product Pid;
	@ManyToOne
	@JoinColumn(name = "AtrId")
	private ProductAttribute AtrId;
	@Column(nullable = false)
	private int values;

	public Product getPid() {
		return Pid;
	}

	public void setPid(Product pid) {
		Pid = pid;
	}

	public ProductAttribute getAtrId() {
		return AtrId;
	}

	public void setAtrId(ProductAttribute atrId) {
		AtrId = atrId;
	}

	public int getValues() {
		return values;
	}

	public void setValues(int values) {
		this.values = values;
	}

}