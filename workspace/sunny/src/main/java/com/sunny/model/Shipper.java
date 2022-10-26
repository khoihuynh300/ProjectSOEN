package com.sunny.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Shipper")
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipperId")
	private int ShipperId;

	@OneToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private User UserId;

	@Column(nullable = false)
	private String Name;

	@Column(nullable = false)
	private String Gender;

	private Date DateofBirth;

	@Column(nullable = false)
	private String Address;

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	public int getShipperId() {
		return ShipperId;
	}

	public void setShipperId(int shipperId) {
		ShipperId = shipperId;
	}

	public User getUserId() {
		return UserId;
	}

	public void setUserId(User userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDateofBirth() {
		return DateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		DateofBirth = dateofBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
