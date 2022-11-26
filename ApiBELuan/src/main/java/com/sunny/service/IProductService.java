package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;

public interface IProductService {
	Product create(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Product product);

	List<Product> getAllProduct(int pageNumber, int pageSize);

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize);

	List<Product> getProductByPrice(Double start, Double end);

	List<Product> getProducts(int pageNumber, int pageSize, Integer ptype);

	Product getProductById(int id);

	List<Product> getRecommendedProducts(int ptype, int size);

	List<Product> getTopItemByPtype(int Ptype);

	List<Product> getAllProductByPtype(int Ptype, int pageNumber, int pageSize);

	Long count(Integer cateid);

	Product bestSeller();

	Product bestSellerOfAProductType(int id);

	Product bestIncome();

	Product bestIncomeOfAProductType(int id);
}
