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
	private String val;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}