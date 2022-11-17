package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "Image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(nullable = false)
	private String picture1;
	@Column(nullable = false)
	private String picture2;
	@Column(nullable = false)
	private String picture3;
	@Column(nullable = false)
	private String picture4;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getPicture4() {
		return picture4;
	}

	public void setPicture4(String picture4) {
		this.picture4 = picture4;
	}

	public Image(String picture1, String picture2, String picture3, String picture4) {
		super();
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
		this.picture4 = picture4;
	}

	public Image() {
		// TODO Auto-generated constructor stub
	}
	
}
