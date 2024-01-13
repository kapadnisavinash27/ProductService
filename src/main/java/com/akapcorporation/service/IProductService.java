package com.akapcorporation.service;

import java.util.List;

import com.akapcorporation.entity.Product;

public interface IProductService {

	public String addProduct(Product product);
	public List<Product> allProducts();
	
}
