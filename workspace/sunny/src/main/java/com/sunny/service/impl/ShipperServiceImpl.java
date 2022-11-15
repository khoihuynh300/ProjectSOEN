package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IShipperDao;
import com.sunny.dao.impl.ShipperDaoImpl;
import com.sunny.model.Shipper;
import com.sunny.service.IShipperService;

public class ShipperServiceImpl implements IShipperService {

	private IShipperDao shipperDao = new ShipperDaoImpl();

	@Override
	public Result createShipper(Shipper shipper) {
		shipperDao.createShipper(shipper);
		return new Result(true, "Create Shipper successfully!!!");
	}

	@Override
	public List<Shipper> getAllShipper() {
		return shipperDao.getAllShipper();
	}

	@Override
	public Result updateShipper(Shipper shipper) {
		shipperDao.updateShipper(shipper);
		return new Result(true, "Update Shipper successfully!!!");
	}

	@Override
	public Result activateShipper(Shipper shipper) {
		shipperDao.activateShipper(shipper);
		return new Result(true, "Activate Shipper successfully!!!");
	}

	@Override
	public Result deleteShipper(Shipper shipper) {
		shipperDao.deleteShipper(shipper);
		return new Result(true, "Delete Shipper successfully!!!");
	}

	@Override
	public Shipper getShipperById(int id) {
		return shipperDao.getShipperById(id);
	}

	@Override
	public Shipper getShipperByUserId(int userId) {
		return shipperDao.getShipperByUserId(userId);
	}

}
