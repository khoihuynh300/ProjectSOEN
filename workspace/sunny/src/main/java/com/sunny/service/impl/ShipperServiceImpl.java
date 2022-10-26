package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IShipperDao;
import com.sunny.dao.impl.ShipperDaoImpl;
import com.sunny.model.Shipper;
import com.sunny.service.IShipperService;

public class ShipperServiceImpl implements IShipperService {

	private IShipperDao shipperDao = new ShipperDaoImpl();

	@Override
	public Shipper createShipper(Shipper shipper) {
		return shipperDao.createShipper(shipper);
	}

	@Override
	public List<Shipper> getAllShipper() {
		return shipperDao.getAllShipper();
	}

	@Override
	public void updateShipper(Shipper shipper) {
		shipperDao.updateShipper(shipper);
	}

	@Override
	public void activateShipper(Shipper shipper) {
		shipperDao.activateShipper(shipper);
	}

	@Override
	public void deleteShipper(Shipper shipper) {
		shipperDao.deleteShipper(shipper);
	}

}
