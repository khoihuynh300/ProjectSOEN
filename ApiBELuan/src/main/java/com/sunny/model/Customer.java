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

import org.hibernate.annotations.Check;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@Entity
@Table(name = "Customer")
//@Check(constraints = "Gender in ('F','M')")

@JsonPropertyOrder({ "cusId", "name", "userId","gender","dateofBirth","address"})
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CusId;

	@OneToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private User UserId;

	@Column(nullable = false)
	private String Name;

	@Column(nullable = false)
	private String Gender;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date DateofBirth;

	@Column(nullable = false)
	private String Address;

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	public void setCusId(int cusId) {
		CusId = cusId;
	}

	public int getCusId() {
		return CusId;
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
