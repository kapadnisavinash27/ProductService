package com.akapcorporation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapcorporation.Repository.ProductRepository;
import com.akapcorporation.entity.Product;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	ProductRepository repo;

	public List<Product> allProducts() {
		
		List <Product> products =repo.findAll();
		
		return products;
	}

	
	public String addProduct(Product product) {
		repo.save(product);
		return product.getProductName()+"  Product Uploaded on MarketPlace succesefully  ";
	}


	

}
