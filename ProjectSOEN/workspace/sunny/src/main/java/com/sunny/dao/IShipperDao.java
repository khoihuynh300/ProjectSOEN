package com.sunny.dao;

import java.util.List;

import com.sunny.model.Shipper;

public interface IShipperDao {

	Shipper createShipper(Shipper shipper);

	List<Shipper> getAllShipper();

	void updateShipper(Shipper shipper);

	void activateShipper(Shipper shipper);

	void deleteShipper(Shipper shipper);

	Shipper getShipperById(int id);

}