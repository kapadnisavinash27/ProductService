package com.akapcorporation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akapcorporation.entity.ProductData;
import com.akapcorporation.service.ProductServiceImp;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200/")
public class ProductRestcontroller {
	
	@Autowired
	ProductServiceImp productservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductData product){
		System.out.println(product.getProductName());
		String msg =productservice.addProduct(product);
		System.out.println(product.getProductName());
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/all")
	public  ResponseEntity<List<ProductData>> allProducts(){
		
		List<ProductData> products=productservice.allProducts();
		return new ResponseEntity<List<ProductData>>(products,HttpStatus.OK);
	}

}
