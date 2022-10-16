package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.model.ProductType;
import com.sunny.service.IProductService;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductAPI {
	private IProductService iProductService=new ProductServiceImpl();
	
	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		return iProductService.AddProduct(product);
	}
	@DeleteMapping("/deleteProduct")
	@Transactional
	public void deleteProduct(@RequestBody Product product) {
		iProductService.DeleteProduct(product.getPid());
	}
	@PutMapping("/editProduct")
	@ResponseBody
	public void editProduct(@RequestBody Product product) throws Exception {
		iProductService.EditProduct(product);
	}
	@PostMapping("/findProduct")
	@ResponseBody
	public Product findProduct(@RequestBody Product product) {
		return iProductService.FindProduct(product.getPid());
	}
	@GetMapping("/getAllProduct")
	@ResponseBody
	public List<Product> getAllProduct(){
		return iProductService.getAllProduct();
	}
	@PostMapping("/filterProductbyPtype")
	@ResponseBody
	public List<Product> filerProductbyPtype(@RequestBody ProductType productType)
	{
		return iProductService.filterProductbyPtype(productType.getPtype());
	}
	
	
}
