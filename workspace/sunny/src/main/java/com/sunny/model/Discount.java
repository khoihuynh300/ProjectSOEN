package com.sunny.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Discount")
@Check(constraints = "Percent >= 0 AND Percent <= 1")
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DiscountId;

	@Column(nullable = false)
	private int Amount;

	@Column(nullable = false)
	private double Percent;

	@Column(nullable = false)
	private Date StartDate;

	@Column(nullable = false)
	private Date StopDate;
	@Column(name = "isDeleted", nullable = false)
	private boolean isDeleted;

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getDiscountId() {
		return DiscountId;
	}

	public void setDiscountId(int discountId) {
		DiscountId = discountId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public double getPercent() {
		return Percent;
	}

	public void setPercent(double percent) {
		Percent = percent;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getStopDate() {
		return StopDate;
	}

	public void setStopDate(Date stopDate) {
		StopDate = stopDate;
	}

}
