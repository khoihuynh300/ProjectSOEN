package com.sunny.pojo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OderDetail")
public class OrderDetail implements Serializable {

	@EmbeddedId
	private OrderDetailPK orderdetailPK;

	private static final long serialVersionUID = 1L;

}

@Embeddable
class OrderDetailPK implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int orderID;
	protected int itemID;

	public OrderDetailPK() {
	}

	public OrderDetailPK(int orderID, int itemID) {
		this.orderID = orderID;
		this.itemID = itemID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemID, orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailPK other = (OrderDetailPK) obj;
		return itemID == other.itemID && orderID == other.orderID;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getItemID() {
		return itemID;
	}

}
