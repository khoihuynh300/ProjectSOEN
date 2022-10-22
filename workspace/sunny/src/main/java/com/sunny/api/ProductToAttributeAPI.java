package com.sunny.api;

import java.util.List;

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

@RestController
@RequestMapping("/productToAttribute")
public class ProductToAttributeAPI {
	private IProductToAttributeService iProductToAttributeService = new ProductToAttributeServiceImpl();

	@PostMapping("/addProductToAttribute")
	@ResponseBody
	public ProductToAttribute addProductToAttribute(@RequestBody ProductToAttribute productToAttribute)
			throws Exception {
		return iProductToAttributeService.addProductToAttribute(productToAttribute);
	}

	@DeleteMapping("/deleteProductToAttribute")
	@ResponseBody
	public void deleteProductToAttribute(@RequestBody ProductToAttribute productToAttribute) {
		iProductToAttributeService.deleteProductToAttribute(productToAttribute.getId());
	}

	@PutMapping("/editProductToAttribute")
	@ResponseBody
	public void editProductToAttribute(@RequestBody ProductToAttribute productToAttribute) {
		iProductToAttributeService.editProductToAttribute(productToAttribute.getId());
	}

	/*
	 * Thay POST thành GET Thay ReqBody thành ReqParam
	 */
	@GetMapping("/getAllProductToAtributebyPid")
	@ResponseBody()
	public List<ProductToAttribute> getAllProductToAttributebyPid(@RequestParam(required = true) Integer pid) {
		return iProductToAttributeService.getAllProducttoAttributebyPid(pid.intValue());
	}
}