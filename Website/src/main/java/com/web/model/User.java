package com.web.model;

public class User {
	private int UserId;
	private String AcountName;
	private String Password;
	private int role;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getAcountName() {
		return AcountName;
	}
	public void setAcountName(String acountName) {
		AcountName = acountName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
