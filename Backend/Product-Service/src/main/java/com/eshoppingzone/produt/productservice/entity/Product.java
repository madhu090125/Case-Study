package com.eshoppingzone.produt.productservice.entity;

import java.util.Set;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
//@AllArgsConstructor 
@Getter
@Setter
@NoArgsConstructor 
//@ToString 
@Document (collection="products")
public class Product {
	@Id 
//	private int productId;
	private long productId;
	
	@NotEmpty(message="Product cannot be empty")
	private String productType;
	
	
	@NotEmpty (message="product name cannot be empty")
	private String productName;
	
	private String category;
	
	private String rating;
	
	private String review;
	
	@NotNull 
	private double price;
	private double discount;
	
	private String description;
	private String images;
//	
//	private String specification;

	
	
}
