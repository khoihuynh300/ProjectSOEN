package com.sunny.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	public Product(int pid, ProductType ptype, String pname, double price, String description, Discount discountId) {
		super();
		Pid = pid;
		Ptype = ptype;
		Pname = pname;
		Price = price;
		Description = description;
		DiscountId = discountId;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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

//	//P
//	
////	@JoinTable(name = "ProducttoAttribute", joinColumns = { @JoinColumn(name = "Pid") }, inverseJoinColumns = { @JoinColumn(name = "Pid") })
//	private Set<ProductToAttribute>productToAttributes= new HashSet<ProductToAttribute>();
//	//P
//	@OneToMany(mappedBy = "product")
//	public Set<ProductToAttribute> getProductToAttribute (){
//		return productToAttributes;
//	}
//	public void setProductToAttributes(Set<ProductToAttribute> productToAttributes) {
//		this.productToAttributes = productToAttributes;
//	}
//
}
