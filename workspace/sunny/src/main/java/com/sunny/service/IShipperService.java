package com.sunny.service;

import java.util.List;

import com.sunny.model.Shipper;

public interface IShipperService {
	Shipper createShipper(Shipper shipper);

	List<Shipper> getAllShipper();

	void updateShipper(Shipper shipper);

	void activateShipper(Shipper shipper);

	void deleteShipper(Shipper shipper);
}
