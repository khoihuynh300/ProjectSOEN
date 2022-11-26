package com.sunny.dao;

import java.util.Date;
import java.util.List;

import com.sunny.model.Product;

public interface IProductDao {
	Product create(Product product);

	List<Product> getAllProduct(int pageNumber, int pageSize);

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize);

	List<Product> getProductByPrice(Double start, Double end);

	Product updateProduct(Product product);

	void deletedProduct(Product product);

	List<Product> getRecords(int start, int total, Integer ptype);

	Product getProductById(int id);

	List<Product> getRecommendedProducts(int ptype, int size);

	List<Product> getTopItemByPtype(int Ptype);

	List<Product> getAllProductByPtype(int Ptype, int pageNumber, int pageSize);

	Long count(Integer cateid);

	Product bestSeller();

	Product bestSellerOfAProductType(int id);

	Product bestIncome();

	Product bestIncomeOfAProductType(int id);

	List<Object[]> nProductBestIncome(int n);

	List<Object[]> nProdcutBestIncomeinInterval(int n, Date start, Date end);
}
