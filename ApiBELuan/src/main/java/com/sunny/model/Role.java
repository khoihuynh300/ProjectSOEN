package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
 
@Entity
@Table(name = "Role")
@JsonPropertyOrder({ "roleId", "moTa"})
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;

	@Column(nullable = false)
	private String MoTa;

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public Role(int roleId) {
		super();
		RoleId = roleId;
	}

	public Role(int roleId, String moTa) {
		super();
		RoleId = roleId;
		MoTa = moTa;
	}

	public Role() {
		super();
	}
}
