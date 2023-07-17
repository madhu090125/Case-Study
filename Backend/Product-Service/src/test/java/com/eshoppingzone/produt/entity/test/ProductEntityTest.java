package com.eshoppingzone.produt.entity.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.eshoppingzone.produt.productservice.entity.Product;

class ProductEntityTest {
	
	@Test
	void testProductEntityTest() {
		Product p1 = new Product();
		Product p2 = new Product();
		
		p1.setProductId(1222);
		p1.setProductType("hello");
		p1.setProductName("abc");
		p1.setCategory("qqqqq");
		p1.setRating("4.3");
		p1.setReview("good");
		p1.setPrice(1200.0);
		p1.setDescription("pretty");
		p1.setDiscount(10.0);
		p1.setImages("a1.jpg");
		
		p1.getProductId();
		p1.getProductType();
		p1.getProductName();
		p1.getCategory();
		p1.getRating();
		p1.getReview();
		p1.getPrice();
		p1.getDescription();
		p1.getDiscount();
		p1.getImages();
		
		assertNotEquals(p1, p2);
		
	}
	

}
