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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.sunny.service.IProductService;

@RestController
@RequestMapping("/admin")
public class ProductAPI {
	@Autowired
	IProductService productService;

	private static final int PAGE_SIZE = 10;

	@Autowired
	ImageDaoImpl img;

	@PostMapping(value = "/product", produces = "application/json")
	@Transactional
	public void createProduct(@RequestParam String product, RedirectAttributes ra, Model model,
			@RequestParam("imageFile") MultipartFile[] multipartFiles, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Product productResp = mapper.readValue(product, Product.class);

		try {
			if (multipartFiles.length != 0) {
				for (MultipartFile multipartFile : multipartFiles) {
					img.storeFile(multipartFile);
				}
				productResp.setImage(img.createImage(multipartFiles));
				productService.create(productResp);
			} else {
				ra.addFlashAttribute("errorMessage",
						"Cannot create product, Please choose Image, Try again! :" + productResp.getPname());
				resp.sendRedirect("/product");
			}
			ra.addFlashAttribute("succeedMessage", "Product " + productResp.getPname() + " Was created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("errorMessage", "Cannot create product :" + productResp.getPname());
		}
	}

//	@GetMapping("/product")
//	@Transactional
//	public ResponseEntity<?> getAllProduct() {
//		List<Product> result = productService.getAllProduct();
//		return ResponseEntity.status(HttpStatus.OK).body(result);
//	}

	@PutMapping("/product")
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

	@DeleteMapping("/product")
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}

}
