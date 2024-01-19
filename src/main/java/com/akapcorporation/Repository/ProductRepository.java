package com.akapcorporation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akapcorporation.entity.ProductData;

public interface ProductRepository extends JpaRepository<ProductData, Integer> {

}
