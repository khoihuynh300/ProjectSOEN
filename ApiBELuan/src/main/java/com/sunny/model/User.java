package com.sunny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "User")
@JsonPropertyOrder({ "userId", "accountName", "password","email","phone","roleId","deleted","enable" })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int UserId;

	@Column(name = "AccountName", nullable = false, unique = true)
	@Size(min = 4, max = 21, message = "Account name must be between 4 and 21 characters")
	private String AccountName;

	@Column(name = "Password", nullable = false)
	private String Password;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Email is not null")
	private String email;

	@Column(nullable = true, unique = true)
	private String Phone;

	@OneToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	private Role RoleId = new Role(2);

	@Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	@Column(name = "enable", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean enable;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Role getRoleId() {
		return RoleId;
	}

	public void setRoleId(Role roleId) {
		RoleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public User(int userId, String accountName, String email, String phone, Role roleId, boolean isDeleted,
			boolean enable) {
		super();
		UserId = userId;
		AccountName = accountName;
		this.email = email;
		Phone = phone;
		RoleId = roleId;
		this.isDeleted = isDeleted;
		this.enable = enable;
	}

	public User() {
	}
	
	
}
