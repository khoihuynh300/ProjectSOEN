package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Shipper;
import com.sunny.service.IShipperService;
import com.sunny.service.impl.Result;
import com.sunny.service.impl.ShipperServiceImpl;

@RestController
@RequestMapping("/shipper")
public class ShipperAPI {
	private IShipperService shipperService = new ShipperServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createShipper(@RequestBody Shipper shipper) {
		return shipperService.createShipper(shipper);
	}

	@GetMapping("/get")
	@Transactional
	public List<Shipper> getAllShipper() {
		return shipperService.getAllShipper();
	}

	@PutMapping("/update")
	@Transactional
	public Result updateShipper(@RequestBody Shipper shipper) {
		return shipperService.updateShipper(shipper);
	}

	@PutMapping("/activate")
	@Transactional
	public Result activateShipper(@RequestBody Shipper shipper) {
		return shipperService.activateShipper(shipper);
	}

	@DeleteMapping("/delete")
	@Transactional
	public Result deleteShipper(@RequestBody Shipper shipper) {
		return shipperService.deleteShipper(shipperService.getShipperById(shipper.getShipperId()));
	}
}
