//package com.eshoppingzone.produt;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//
//import com.eshoppingzone.produt.productservice.entity.ErrorResponse;
//import com.eshoppingzone.produt.productservice.entity.LoggerResponse;
//import com.eshoppingzone.produt.productservice.entity.Product;
//import com.eshoppingzone.produt.productservice.repository.ProductRepository;
//import com.eshoppingzone.produt.productservice.service.ProductServiceImpl;
//
//@SpringBootTest
//class ProductTest {
//
//	@MockBean
//	private ProductRepository productrepository;
//
//	@Autowired
//	private ProductServiceImpl productserviceimpl;
//
//	@Test
//	public void getAllProduct() {
//		List<Product> products = new ArrayList<>();
//		Product p = new Product();
//		p.setProductId(10);
//		p.setProductName("Hello");
//		p.setProductType("Cloth");
//		p.setCategory("Female");
//		p.setDescription("Good");
//		p.setPrice(120);
//		p.setRating("3.4");
//		p.setReview("good");
//		p.setSpecification("no");
//
//		products.add(p);
//
//		when(productrepository.findAll()).thenReturn(products);
//		assertEquals(1, productserviceimpl.getAllProduct().size());
//	}
//
//	@Test
//	public void getAllProductException() {
//		List<Product> products = new ArrayList<>();
//		Product p = new Product();
//
//		when(productrepository.findAll()).thenReturn(products);
//		assertEquals(1, productserviceimpl.getAllProduct().size());
//	}
//
//	@Test
//	public void getProductById_test() {
//		Product p1 = new Product();
//		p1.setProductId(10);
//		p1.setProductName("Hello");
//		p1.setProductType("Cloth");
//		p1.setCategory("Female");
//		p1.setDescription("Good");
//		
//		p1.setPrice(120);
//		p1.setRating("3.4");
//		p1.setReview("good");
//		p1.setSpecification("no");
//
//		Optional<Product> byid = Optional.of(p1);
//		when(productrepository.findById(10)).thenReturn(byid);
//		assertEquals(p1, productserviceimpl.getProductById(10));
//
//	}
//
//	@Test
//	public void getProductByIdException_test() {
//		Product p1 = new Product();
//		p1.setProductId(10);
//		p1.setProductName("Hello");
//		p1.setProductType("Cloth");
//		p1.setCategory("Female");
//		p1.setDescription("Good");
//		
//		p1.setPrice(120);
//		p1.setRating("3.4");
//		p1.setReview("good");
//		p1.setSpecification("no");
//
//		Optional<Product> byid = Optional.of(p1);
//		when(productrepository.findById(10)).thenReturn(byid);
//		assertEquals(p1, productserviceimpl.getProductById(11));
//
//	}
//
//	@Test
//	public void addProduct_test() {
//
//		Product p2 = new Product();
//		p2.setProductId(10);
//		p2.setProductName("Hello");
//		p2.setProductType("Cloth");
//		p2.setCategory("Female");
//		p2.setDescription("Good");
//		
//		p2.setPrice(120);
//		p2.setRating("3.4");
//		p2.setReview("good");
//		p2.setSpecification("no");
//
//		when(productrepository.insert(p2)).thenReturn(p2);
//		assertEquals(p2, productserviceimpl.addProduct(p2));
//
//	}
//
//	@Test
//	public void updateProduct_test() {
//
//		Product p3 = new Product();
//		p3.setProductId(10);
//		p3.setProductName("Hello");
//		p3.setProductType("Cloth");
//		p3.setCategory("Female");
//		p3.setDescription("Good");
//		p3.setPrice(120);
//		p3.setRating("3.4");
//		p3.setReview("good");
//		p3.setSpecification("no");
//
//		Product p4 = new Product();
//		p4.setProductId(10);
//		p4.setProductName("Hi");
//		p4.setProductType("Clothes");
//		p4.setCategory("Female");
//		p4.setDescription("Good");
//		p4.setPrice(1200);
//		p4.setRating("4.4");
//		p4.setReview("good");
//		p4.setSpecification("yes");
//
//		Optional<Product> update = Optional.of(p3);
//		when(productrepository.findById(10)).thenReturn(update);
//		when(productrepository.save(p4)).thenReturn(p4);
//		assertEquals(p4, productserviceimpl.updateProducts(p4));
//	}
//
//	@Test
//	public void updateProductException_test() {
//
//		Product p3 = new Product();
//		p3.setProductId(10);
//		p3.setProductName("Hello");
//		p3.setProductType("Cloth");
//		p3.setCategory("Female");
//		p3.setDescription("Good");
//		p3.setPrice(120);
//		p3.setRating("3.4");
//		p3.setReview("good");
//		p3.setSpecification("no");
//
//		Product p4 = new Product();
//		p4.setProductId(11);
//		p4.setProductName("Hi");
//		p4.setProductType("Clothes");
//		p4.setCategory("Female");
//		p4.setDescription("Good");
//		p4.setPrice(1200);
//		p4.setRating("4.4");
//		p4.setReview("good");
//		p4.setSpecification("yes");
//
//		Optional<Product> update = Optional.of(p3);
//		when(productrepository.findById(10)).thenReturn(update);
//		when(productrepository.save(p4)).thenReturn(p4);
//		assertEquals(p4, productserviceimpl.updateProducts(p4));
//	}
//
//	
//	@Test
//	public void deleteProduct_test() {
//
//		Product p5 = new Product();
//		p5.setProductId(10);
//		p5.setProductName("Hello");
//		p5.setProductType("Cloth");
//		p5.setCategory("Female");
//		p5.setDescription("Good");
//		p5.setPrice(120);
//		p5.setRating("3.4");
//		p5.setReview("good");
//		p5.setSpecification("no");
//
//		Optional<Product> delete = Optional.of(p5);
//		when(productrepository.findById(10)).thenReturn(delete);
//		assertEquals("Deleted successfully", productserviceimpl.deleteProductById(10));
//	}
//	
//	@Test
//	public void deleteProductException_test() {
//
//		Product p5 = new Product();
//		p5.setProductId(10);
//		p5.setProductName("Hello");
//		p5.setProductType("Cloth");
//		p5.setCategory("Female");
//		p5.setDescription("Good");
//		p5.setPrice(120);
//		p5.setRating("3.4");
//		p5.setReview("good");
//		p5.setSpecification("no");
//
//		Optional<Product> delete = Optional.of(p5);
//		when(productrepository.findById(10)).thenReturn(delete);
//		assertEquals("Deleted successfully", productserviceimpl.deleteProductById(11));
//	}
//
//	@Test
//	public void getProductByName_test() {
//		Product p6 = new Product();
//		p6.setProductId(10);
//		p6.setProductName("Hello");
//		p6.setProductType("Cloth");
//		p6.setCategory("Female");
//		p6.setDescription("Good");
//		
//		p6.setRating("3.4");
//		p6.setReview("good");
//		p6.setSpecification("no");
//
//		List<Product> byname = List.of(p6);
//		when(productrepository.findByProductName("Hello")).thenReturn(byname);
//		assertEquals(byname, productserviceimpl.getProductByName("Hello"));
//
//	}
//	
//	@Test
//	public void getProductByNameException_test() {
//		Product p6 = new Product();
//		p6.setProductId(10);
//		p6.setProductName("Hello");
//		p6.setProductType("Cloth");
//		p6.setCategory("Female");
//		p6.setDescription("Good");
//		p6.setPrice(120);
//		p6.setRating("3.4");
//		p6.setReview("good");
//		p6.setSpecification("no");
//
//		List<Product> byname = List.of(p6);
//		when(productrepository.findByProductName("Hello")).thenReturn(byname);
//		assertEquals(byname, productserviceimpl.getProductByName("Hi"));
//
//	}
//
//	@Test
//	public void getProductByCategory_test() {
//
//		Product p7 = new Product();
//		p7.setProductId(10);
//		p7.setProductName("Hello");
//		p7.setProductType("Cloth");
//		p7.setCategory("Female");
//		p7.setDescription("Good");
//		p7.setPrice(120);
//		p7.setRating("3.4");
//		p7.setReview("good");
//		p7.setSpecification("no");
//
//		List<Product> bycategory = List.of(p7);
//		when(productrepository.findByCategory("Female")).thenReturn(bycategory);
//		assertEquals(bycategory, productserviceimpl.getProductByCategory("Female"));
//
//	}
//	
//	@Test
//	public void getProductByCategoryException_test() {
//
//		Product p7 = new Product();
//		p7.setProductId(10);
//		p7.setProductName("Hello");
//		p7.setProductType("Cloth");
//		p7.setCategory("Female");
//		p7.setDescription("Good");
//		p7.setPrice(120);
//		p7.setRating("3.4");
//		p7.setReview("good");
//		p7.setSpecification("no");
//
//		List<Product> bycategory = List.of(p7);
//		when(productrepository.findByCategory("Female")).thenReturn(bycategory);
//		assertEquals(bycategory, productserviceimpl.getProductByCategory("male"));
//
//	}
//
//	@Test
//	public void getProductByType_test() {
//
//		Product p8 = new Product();
//		p8.setProductId(10);
//		p8.setProductName("Hello");
//		p8.setProductType("Cloth");
//		p8.setCategory("Female");
//		p8.setDescription("Good");
//		p8.setPrice(120);
//		p8.setRating("3.4");
//		p8.setReview("good");
//		p8.setSpecification("no");
//
//		List<Product> bytype = List.of(p8);
//		when(productrepository.findByProductType("Cloth")).thenReturn(bytype);
//		assertEquals(bytype, productserviceimpl.getProductByType("Cloth"));
//
//	}
//	
//	@Test
//	public void getProductByTypeException_test() {
//
//		Product p8 = new Product();
//		p8.setProductId(10);
//		p8.setProductName("Hello");
//		p8.setProductType("Cloth");
//		p8.setCategory("Female");
//		p8.setDescription("Good");
//		p8.setPrice(120);
//		p8.setRating("3.4");
//		p8.setReview("good");
//		p8.setSpecification("no");
//
//		List<Product> bytype = List.of(p8);
//		when(productrepository.findByProductType("Cloth")).thenReturn(bytype);
//		assertEquals(bytype, productserviceimpl.getProductByType("Clothess"));
//
//	}
//
//	@Test
//	public void errorResponse_test() {
//		ErrorResponse e = new ErrorResponse();
//
//		e.setMessage("NOT NULL");
//		e.setStatusmessage(null);
//		e.setDatetime(LocalDateTime.now());
//
//	}
//
//	@Test
//	public void errorResponses_test() {
//
//		ErrorResponse e1 = new ErrorResponse(HttpStatus.OK, "NOT NULL", LocalDateTime.now());
//		e1.setMessage("NOT NULL");
//		e1.setStatusmessage(HttpStatus.OK);
//		e1.setDatetime(LocalDateTime.now());
//
//	}
//
//	@Test
//	public void LoggerResponse_test() {
//		LoggerResponse l = new LoggerResponse();
//		l.setMessage("NOT FOUND");
//
//	}
//
//	@Test
//	public void LoggerResponses_test() {
//		LoggerResponse l = new LoggerResponse("Not Found");
//		l.setMessage("NOt Null");
//		l.getMessage();
//	}
//
//	@Test
//	public void productConstructor_test() {
//		Product p4 = new Product(1, "Clothing", "Jeans", "Aparel", "3.3", "Good", 200.0, "cotton", "all");
//
//		p4.setProductId(14);
//		p4.setProductName("Pen");
//		p4.setProductType("Sationary");
//		p4.setCategory("Book");
//		p4.setDescription("Point pen");
//		p4.setPrice(5.0);
//		p4.setRating("3.3");
//		p4.setReview("Good");
//		p4.setSpecification("for all");
//	}
//	
//	@Test
//	public void productDefaultConstructor_test() {
//		
//		Product p4 = new Product();
//		p4.setProductId(14);
//		p4.setProductName("Pen");
//		p4.setProductType("Sationary");
//		p4.setCategory("Book");
//		p4.setDescription("Point pen");
//		p4.setPrice(5.0);
//		p4.setRating("3.3");
//		p4.setReview("Good");
//		p4.setSpecification("for all");
//	}
//	
//
//}
//
