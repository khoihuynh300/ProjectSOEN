package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductAttribute")
public class ProductAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AtrId;

	@Column(nullable = false)
	private String AtrName;

	@Column(nullable = false)
	private String unit;

	@Column(nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	public int getAtrId() {
		return AtrId;
	}

	public String getAtrName() {
		return AtrName;
	}

	public void setAtrName(String atrName) {
		AtrName = atrName;
	}

	public void setAtrId(int atrId) {
		AtrId = atrId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}