package com.sunny.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "ProductToAttribute")


public class ProductToAttribute {
	
//	@EmbeddedId	
//	private ProductToAttributeId id =new ProductToAttributeId();
//	@Column(nullable = false)
//	private int values;
//	
//	public ProductToAttributeId getId() {
//		return id;
//	}
//	public void setId(ProductToAttributeId id) {
//		this.id = id;
//	}
//	public int getValues() {
//		return values;
//	}
//	public void setValues(int values) {
//		this.values = values;
//	}
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
	private int val;

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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}



}