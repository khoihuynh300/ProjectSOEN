package com.sunny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RId;

	@Column(nullable = false)
	private double star;

	private String comment;

	@OneToOne
	@JoinColumn(name = "Pid", nullable = false)
	private Product Pid;

	@OneToOne
	@JoinColumn(name = "UserId", nullable = false)
	private User UserId;

	public int getRId() {
		return RId;
	}

	public void setRId(int rId) {
		RId = rId;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Product getPid() {
		return Pid;
	}

	public void setPid(Product pid) {
		Pid = pid;
	}

	public User getUserId() {
		return UserId;
	}

	public void setUserId(User userId) {
		UserId = userId;
	}

}
