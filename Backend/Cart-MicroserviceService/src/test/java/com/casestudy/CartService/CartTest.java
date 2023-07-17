//package com.casestudy.CartService;
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
//import com.casestudy.CartService.entity.Cart;
//import com.casestudy.CartService.entity.ErrorResponse;
//import com.casestudy.CartService.entity.Items;
//import com.casestudy.CartService.entity.Product;
//import com.casestudy.CartService.repository.CartRepository;
//import com.casestudy.CartService.service.CartServiceImpl;
//
//@SpringBootTest
//class CartTest {
//
//	@MockBean
//	private CartRepository cartrepository;
//
//	@Autowired
//	private CartServiceImpl cartserviceimpl;
//
//	@Test
//	public void getAllCart_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img", 0);
//    	it.add(items);
//		List<Cart> carts = new ArrayList<>();
//		Cart c = new Cart();
//		c.setCartId("1");
//		c.setTotalPrice(1200);
//		c.setItems(it);
//
//		carts.add(c);
//		when(cartrepository.findAll()).thenReturn(carts);
//		assertEquals(1, cartserviceimpl.getallcarts().size());
//
//	}
//
//	@Test
//	public void getCartById_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img", 0);
//    	it.add(items);
//		Cart c1 = new Cart();
//		c1.setCartId("10");
//		c1.setTotalPrice(1200);
//		c1.setItems(it);
//
//		when(cartrepository.existsById("10")).thenReturn(true);
//		when(cartrepository.findById("10")).thenReturn(c1);
//		assertEquals(c1, cartserviceimpl.getCartById("10"));
//	}
//
//	@Test
//	public void addCart_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c2 = new Cart();
//		c2.setCartId(10);
//		c2.setTotalPrice(1200);
//		c2.setItems(it);
//
//		when(cartrepository.existsById(10)).thenReturn(false);
//		when(cartrepository.save(c2)).thenReturn(c2);
//		assertEquals(c2, cartserviceimpl.addCart(c2));
//	}
//
//	@Test
//	public void updateCart_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c3 = new Cart();
//		c3.setCartId(10);
//		c3.setTotalPrice(1200);
//		c3.setItems(it);
//
//		Cart c4 = new Cart();
//		c4.setCartId(10);
//		c4.setTotalPrice(1200);
//		c4.setItems(it);
//
//		when(cartrepository.existsById(10)).thenReturn(true);
//		when(cartrepository.findById(10)).thenReturn(c3);
//		when(cartrepository.save(c4)).thenReturn(c4);
//		assertEquals(c4, cartserviceimpl.updateCart(10, c4));
//
//	}
//
//	@Test
//	public void deleteCart_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c3 = new Cart();
//		c3.setCartId(10);
//		c3.setTotalPrice(1200);
//		c3.setItems(it);
//
//		when(cartrepository.existsById(10)).thenReturn(true);
//		when(cartrepository.findById(10)).thenReturn(c3);
//		assertEquals("Deleted Successfully", cartserviceimpl.deleteCartById(10));
//	}
//
//	@Test
//	public void cartTotal_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c3 = new Cart();
//		c3.setCartId(10);
//		c3.setTotalPrice(1200);
//		c3.setItems(it);
//
//		when(cartrepository.existsById(10)).thenReturn(true);
//		when(cartrepository.findById(10)).thenReturn(c3);
//		assertEquals(1200, cartserviceimpl.cartTotal(c3));
//	}
//
//	@Test
//	public void getCartByIdException_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c1 = new Cart();
//		c1.setCartId(10);
//		c1.setTotalPrice(1200);
//		c1.setItems(it);
//
//		when(cartrepository.existsById(11)).thenReturn(false);
//		when(cartrepository.findById(11)).thenReturn(c1);
//		assertEquals(c1, cartserviceimpl.getCartById(11));
//	}
//
//	@Test
//	public void updateCartException_test() {
//
//		List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//		Cart c3 = new Cart();
//		c3.setCartId(10);
//		c3.setTotalPrice(1200);
//		c3.setItems(it);
//
//		Cart c4 = new Cart();
//		c4.setCartId(11);
//		c4.setTotalPrice(1200);
//		c4.setItems(it);
//
//		when(cartrepository.existsById(11)).thenReturn(false);
//		when(cartrepository.findById(11)).thenReturn(c3);
//		when(cartrepository.save(c4)).thenReturn(c4);
//		assertEquals(c4, cartserviceimpl.updateCart(11, c4));
//
//	}
//
//	@Test
//	public void getAllCartException_test() {
//
//		List<Cart> carts = new ArrayList<>();
//		Cart c = new Cart();
//
//		when(cartrepository.findAll()).thenReturn(carts);
//		assertEquals(1, cartserviceimpl.getallcarts());
//
//	}
//
//	@Test
//	public void product_test() {
//		Product p = new Product();
//		p.setProductId(1);
//		p.setCategory("book");
//		p.setDescription("cotton");
//		p.setImage("img");
//		p.setPrice(10.0);
//		p.setProductName("Soap");
//		p.setProductType("Appearel");
//		p.setRating(2.3);
//		p.setReview("good");
//		p.setSpecification("all");
//
//	}
//
//	@Test
//	public void products_test() {
//		Product p = new Product(1, "Appearel", "soap", "book", 2.3, "good", "img", 10.0, "cotton", "all");
//		p.setProductId(1);
//		p.setCategory("book");
//		p.setDescription("cotton");
//		p.setImage("img");
//		p.setPrice(10.0);
//		p.setProductName("Soap");
//		p.setProductType("Appearel");
//		p.setRating(2.3);
//		p.setReview("good");
//		p.setSpecification("all");
//
//	}
//
//	@Test
//	public void item_test() {
//		Items i = new Items();
//		i.setImage("img");
//		i.setPrice(10.0);
//		i.setProductId(1);
//		i.setProductName("Soap");
//		i.setQuantity(2);
//	}
//
//	@Test
//	public void items_test() {
//		Items i = new Items(1, "soap", 10.1, 2, "img");
//
//		i.setImage("img");
//		i.setPrice(10.0);
//		i.setProductId(1);
//		i.setProductName("Soap");
//		i.setQuantity(2);
//	}
//
//	@Test
//	public void ErrorResponse_test() {
//		ErrorResponse e = new ErrorResponse();
//		e.setStatusmessage(HttpStatus.OK);
//		e.setDatetime(LocalDateTime.now());
//		e.setMessage("not null");
//	}
//
//	@Test
//	public void ErrorResponses_test() {
//		ErrorResponse e = new ErrorResponse(HttpStatus.OK, "Not null", LocalDateTime.now());
//		e.setStatusmessage(HttpStatus.OK);
//		e.setDatetime(LocalDateTime.now());
//		e.setMessage("not null");
//	}
//
//	@Test
//	public void cartUser_test() {
//		User1 c = new User1();
//		c.setId("1");
//		c.setPassword("hgfj");
//		c.setUsername("nikki");
//	}
//	
//	@Test
//    public void cartConstructor_test() {
//    	List<Items> it = new ArrayList<>();
//    	Items items = new Items(12, "Saree", 120, 1, "img");
//    	it.add(items);
//    	Cart c = new Cart(1, it, 120);
//    	c.setCartId(1);
//    	c.setItems(it);
//    	c.setTotalPrice(120);
//    }
//	
//	@Test
//	public void cartDefaultConstructor_test() {
//		List<Items> it = new ArrayList<>();
//		Items items = new Items();
//		it.add(items);
//		Cart c = new Cart();
//		c.setCartId(1);
//    	c.setItems(it);
//    	c.setTotalPrice(120);
//	}
//	
//}
