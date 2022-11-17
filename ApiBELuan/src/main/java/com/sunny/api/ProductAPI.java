package com.sunny.api;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.dao.impl.ImageDaoImpl;
import com.sunny.model.Image;
import com.sunny.model.Product;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductService;
import com.sunny.service.IProductToAttributeService;
import com.sunny.service.impl.ProductToAttributeServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductAPI {
	@Autowired
	IProductService productService;

	private static final int PAGE_SIZE = 10;
	private IProductToAttributeService productToAttributeService = new ProductToAttributeServiceImpl();

	@Autowired
	ImageDaoImpl img;

	@PostMapping(value = "/create", produces = "application/json")
	//@PostMapping(value = "/create", consumes = {"multipart/form-data", "application/octet-stream", "application/json"})
	@Transactional
	public ResponseEntity<?> createProduct(@RequestParam String product, RedirectAttributes ra, Model model,
			@RequestParam("imageFile") MultipartFile[] multipartFiles,@RequestParam String ptoattrs, HttpServletResponse resp) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Product productResp = mapper.readValue(product, Product.class);
		try {
			
			if (multipartFiles.length != 0) {
				for (MultipartFile multipartFile : multipartFiles) {
					System.err.println("storeimage");
					img.storeFile(multipartFile);
				}
				productResp.setImage(img.createImage(multipartFiles));
				productResp = productService.create(productResp);
			} else {
				ra.addFlashAttribute("errorMessage",
						"Cannot create product, Please choose Image, Try again! :" + productResp.getPname());
				//resp.sendRedirect("/product");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Chưa có ảnh");
			}
			ra.addFlashAttribute("succeedMessage", "Product " + productResp.getPname() + " Was created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("errorMessage", "Cannot create product :" + productResp.getPname());
		}
		
//		for (ProductToAttribute ptoattr : ptoattrs) {
//			try {
//				ptoattr.setPid(productResp);
//				productToAttributeService.addProductToAttribute(ptoattr);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return ResponseEntity.status(HttpStatus.OK).body("Thêm thành công");
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "1") Integer pageNumber) {
		List<Product> result = productService.getAllProduct(pageNumber.intValue(), PAGE_SIZE);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/get-product-by-id")
	@Transactional
	ResponseEntity<?> get(@RequestParam Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id.intValue()));
	}
	
	@GetMapping("/get-by-ptype")
	@Transactional
	public ResponseEntity<?> getAllProductById(@RequestParam Integer ptype, @RequestParam(defaultValue = "1") Integer pageNumber) {
		List<Product> result = productService.getAllProductByPtype(ptype.intValue(), pageNumber.intValue(), 8);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PutMapping("/update")
	public void updateProduct(@RequestParam String product,
			@RequestParam(value = "imageFile", required = false) MultipartFile[] multipartFiles, RedirectAttributes ra,
			HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Product productResp = mapper.readValue(product, Product.class);

		if (multipartFiles.length == 0)
			productService.updateProduct(productResp);
		else {
			try {
				for (MultipartFile multipartFile : multipartFiles) {
					img.storeFile(multipartFile);
				}
				productResp.setImage(img.createImage(multipartFiles));
				productService.updateProduct(productResp);
				ra.addFlashAttribute("succeedMessage",
						"Product " + productResp.getPname() + " was updated successfully");
			} catch (Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("errorMessage", "Cannot create product :" + productResp.getPname());
			}
		}
	}

	@DeleteMapping("/delete")
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}
	
	@GetMapping("/recommended")
	@Transactional
	public List<Product> getRecommendedProducts(@RequestParam(required = true) Integer size,
			@RequestParam(required = true) Integer ptype) {
		return productService.getRecommendedProducts(ptype.intValue(), size.intValue());
	}

	@GetMapping("/topitem")
	@Transactional
	public List<Product> getTopItemByPtype(@RequestParam(required = true) Integer ptype) {
		return productService.getTopItemByPtype(ptype.intValue());
	}

}
