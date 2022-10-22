package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductType")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Ptype;

	@Column(nullable = false)
	private String PtypeName;

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getPtype() {
		return Ptype;
	}

	public String getPtypeName() {
		return PtypeName;
	}

	public void setPtypeName(String ptypeName) {
		PtypeName = ptypeName;
	}

	public void setPtype(int ptype) {
		Ptype = ptype;
	}

}