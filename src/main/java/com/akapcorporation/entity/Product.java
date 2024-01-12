package com.akapcorporation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductId")
	private Integer ProductId;
	
	@Column(name="ProductName")
	@JsonProperty("ProductName")
	private String ProductName;
	
	

	@Column(name="Prize")
	@JsonProperty("Prize")
	private Long Prize;

	@Column(name="Quantity")
	@JsonProperty("Quantity")
	private Integer Quantity;
	
}
