package com.sunny.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int employeeID;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	private User user;

	@Column(name = "EmployeeName")
	private String employeeName;

	@Column(name = "job")
	private String job;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public User getUser() {
		return user;
	}

}
