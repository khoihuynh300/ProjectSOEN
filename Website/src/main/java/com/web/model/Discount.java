package com.web.model;

import java.util.Date;

public class Discount {
	private int DiscountId;
	private int Amount;
	private double Percent;
	private Date StartDate;
	private Date StopDate;
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
