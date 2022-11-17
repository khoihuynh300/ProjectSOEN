package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Shipper;
import com.sunny.service.IShipperService;
import com.sunny.service.impl.Result;
import com.sunny.service.impl.ShipperServiceImpl;
@CrossOrigin
@RestController(value = "ShipperControllerOfAdmin")
@RequestMapping("/admin/shipper")
public class ShipperAPI {
	private IShipperService shipperService = new ShipperServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createShipper(@RequestBody Shipper shipper) {
		return shipperService.createShipper(shipper);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(shipperService.getAllShipper())
				: ResponseEntity.status(HttpStatus.OK).body(shipperService.getShipperById(id.intValue()));
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
