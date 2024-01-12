package com.akapcorporation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Column(name="ProductId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ProductId;
	
	@Column(name="ProductId")
	private String ProductName;
	
	@Column(name="Prize")
	private Long Prize;
	
	
}
