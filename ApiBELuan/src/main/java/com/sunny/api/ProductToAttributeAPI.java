package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductToAttributeService;
import com.sunny.service.impl.ProductToAttributeServiceImpl;
import com.sunny.service.impl.Result;
@CrossOrigin
@RestController
@RequestMapping("/productToAttribute")
public class ProductToAttributeAPI {
	private IProductToAttributeService productToAttributeService = new ProductToAttributeServiceImpl();

	@PostMapping("/add")
	@ResponseBody
	public Result addProductToAttribute(@RequestBody ProductToAttribute productToAttribute) throws Exception {
		return productToAttributeService.addProductToAttribute(productToAttribute);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public Result deleteProductToAttribute(@RequestBody ProductToAttribute productToAttribute) {
		return productToAttributeService.deleteProductToAttribute(productToAttribute.getId());
	}

	@PutMapping("/edit")
	@ResponseBody
	public Result editProductToAttribute(@RequestBody ProductToAttribute productToAttribute) {
		return productToAttributeService.editProductToAttribute(productToAttribute.getId());
	}

	/*
	 * Thay POST thành GET Thay ReqBody thành ReqParam
	 */
	@GetMapping("/get-by-pid")
	@ResponseBody()
	public List<ProductToAttribute> getAllProductToAttributebyPid(@RequestParam(required = true) Integer pid) {
		return productToAttributeService.getAllProducttoAttributebyPid(pid.intValue());
	}

	@GetMapping("/get")
	@Transactional
	public ProductToAttribute getProductToAttributeById(@RequestParam(required = true) Integer id) {
		return productToAttributeService.getProductToAttributeById(id.intValue());
	}
}