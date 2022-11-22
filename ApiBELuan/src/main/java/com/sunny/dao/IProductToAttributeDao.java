package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductAttribute;
import com.sunny.model.ProductToAttribute;

public interface IProductToAttributeDao {
	ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute);

	void deleteProductToAttribute(int id);

	void editProductToAttribute(int AtrId);

	List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid);

	ProductToAttribute getProductToAttributeById(int id);

	// Thêm tất cả những thuộc tính cần có cho một sản phẩm
	List<ProductToAttribute> addAllAttributeToProductbyPid(int Pid, List<ProductAttribute> listAllProductAttributes);

	// Thêm giá trị cho những thuộc tính
	// Chỉnh sửa những thuộc tính của mộ sản phẩm
	List<ProductToAttribute> editAllAttributeToProductbyPid(int Pid, List<ProductAttribute> listAllProductAttributes);
}
