package com.sunny.service;

import java.util.List;

import com.sunny.model.Shipper;
import com.sunny.service.impl.Result;

public interface IShipperService {
	Result createShipper(Shipper shipper);

	List<Shipper> getAllShipper();

	Result updateShipper(Shipper shipper);

	Result activateShipper(Shipper shipper);

	Result deleteShipper(Shipper shipper);

	Shipper getShipperById(int id);

}
