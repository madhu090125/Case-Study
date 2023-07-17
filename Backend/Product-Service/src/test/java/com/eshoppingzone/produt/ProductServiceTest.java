//package com.eshoppingzone.produt;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//
//import com.eshoppingzone.produt.productservice.entity.Product;
//import com.eshoppingzone.produt.productservice.repository.ProductRepository;
//import com.eshoppingzone.produt.productservice.resource.ProductResource;
//import com.eshoppingzone.produt.productservice.service.ProductServiceImpl;
//
//@SpringBootTest(classes = {Product .class})
//class ProductServiceTest {
//	
//	@Mock
//	ProductServiceImpl productserviceimpl;
//	
//	@InjectMocks
//	ProductResource productresource;
//	
//	@MockBean
//	ProductRepository productrepository;
//	
//	List<Product>products;
//	Product product; 
//	
//	@Test
//	public void test_getAllProduct() {
//		products=new ArrayList<>();
//		products.add(new Product(1,"Clothing","Torn jeans","Book", "4","good product","imag", 1000,"mom cut","only for girls"));
//		products.add(new Product(2,"Gadgets","Boat Air Buds","Electronics", "4.2","nice product","imag1", 1500,"Usable","for everyone"));
//		
//		when(productserviceimpl.getAllProduct()).thenReturn(products);
//		ResponseEntity<List<Product>> allProduct=productresource.getAllProduct();
//		assertEquals(2,allProduct.getBody().size());
//	}
//	
//	@Test
//	public void test_getProductById() {
//		
//		
//		//product=new Product(1,"Clothing","Torn jeans","Book", "4","good product","imag", 1000,"mom cut","only for girls");
//		product=new Product(2,"Gadgets","Boat Air Buds","Electronics", "4.2","nice product","imag1", 1500,"Usable","for everyone");
//		int productId=2;
//		
//		when(productserviceimpl.getProductById(productId)).thenReturn(product);
//		ResponseEntity<Product> productById=productresource.getProductById(productId);
//		assertEquals(productId, productById.getBody().getProductId());	
//	}
//	
//	@Test
//	public void test_addProduct() {
//		product=new Product(1,"Clothing","Torn jeans","Book", "4","good product","imag", 1000,"mom cut","only for girls");
//		int productId=1;
//		
//		when(productserviceimpl.getProductById(productId)).thenReturn(product);
//		when(productserviceimpl.addProduct(product)).thenReturn(product);
//		ResponseEntity<Product>addProduct=productresource.addProduct(product);
//		assertEquals(productId, addProduct.getBody().getProductId());
//	}
//	
//	@Test
//	public void test_updateProducts() {
//		
//		product=new Product(1,"Clothing","Torn jeans","Book", "4","good product","imag", 1000,"mom cut","only for girls");
//		int productId=1;
//		
//		when(productserviceimpl.getProductById(productId)).thenReturn(product);
//		when(productserviceimpl.updateProducts(product)).thenReturn(product);
//		ResponseEntity<Product>updateProduct=productresource.updateProducts(product);
//		assertEquals(1,updateProduct.getBody().getProductId());	
//	}
//	
//	@Test
//	public void test_deleteProductById() {
//		product=new Product(1,"Clothing","Torn jeans","Book", "4","good product","imag", 1000,"mom cut","only for girls");
//		int productId=1;
//		productrepository.deleteById(productId);
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	/*
//	 * @Test public void test_getProductByName() { product=new
//	 * Product(1,"Clothing","Torn jeans","Book", "4","good product","imag",
//	 * 1000,"mom cut","only for girls"); int productId=1; String name="Torn jeans";
//	 * 
//	 * when(productserviceimpl.getProductById(productId)).thenReturn(product);
//	 * when(productserviceimpl.getProductByName(name)).thenReturn(products);
//	 * ResponseEntity<List<Product>>
//	 * productName=productresource.getProductByName(name);
//	 * assertEquals(productId,productName.getBody().getProductId());
//	 * 
//	 * }
//	 */
//	/*
//	 * @Test void test() { fail("Not yet implemented"); }
//	 */
//
//}
