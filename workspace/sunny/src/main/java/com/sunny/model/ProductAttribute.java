package com.sunny.model;

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
	private String AtrName;

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

}