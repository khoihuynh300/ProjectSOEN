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

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "Employee")
@JsonPropertyOrder({ "empId", "name", "userId","gender","DateofBirth","address","job","luongThang" })
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmpId;

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

	@Column(nullable = false)
	private String Job;

	@Column(nullable = false)
	private double LuongThang;

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
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

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public double getLuongThang() {
		return LuongThang;
	}

	public void setLuongThang(double luongThang) {
		LuongThang = luongThang;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
