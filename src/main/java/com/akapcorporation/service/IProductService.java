package com.akapcorporation.service;

import java.util.List;

import com.akapcorporation.entity.ProductData;

public interface IProductService {

	public String addProduct(ProductData product);
	public List<ProductData> allProducts();
	
}
