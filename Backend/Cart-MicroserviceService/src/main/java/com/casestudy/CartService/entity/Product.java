package com.casestudy.CartService.entity;

import java.util.List;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product")
public class Product {
	@Id
	private int productId;
	@NotEmpty(message = "ProductType is empty")
	private String productType;
	@NotEmpty(message = "Product Name is empty")
	private String productName;
	private String category;
	private double rating;
	private String review;
	private String images;
	@NotNull
	private double price;
	private String description;
	private String specification;
	private double discount;

}