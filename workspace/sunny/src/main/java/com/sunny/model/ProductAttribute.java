package com.sunny.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
//	//P
//	@OneToMany(mappedBy = "AtrId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<ProductToAttribute>productToAttributes;
//	
//	public Set<ProductToAttribute>getProductToAttributes(){
//		return productToAttributes;
//	}
//	public void setProductToAttributes(Set<ProductToAttribute> productToAttributes) {
//		this.productToAttributes = productToAttributes;
//	}

	
}