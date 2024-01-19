package com.akapcorporation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapcorporation.entity.ProductData;
import com.akapcorporation.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	private ProductRepository repo;

	public List<ProductData> allProducts() {
		
		List <ProductData> products =repo.findAll();
		
		return products;
	}

	
	public String addProduct(ProductData product) {
		repo.save(product);
		return product.getProductName()+"  Product Uploaded on MarketPlace succesefully  ";
	}


	

}
