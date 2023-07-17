package com.casestudy.CartService.controller;

import java.util.ArrayList;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.casestudy.CartService.entity.AutenticationRequest;
//import com.casestudy.CartService.entity.AutenticationResponse;
import com.casestudy.CartService.entity.Cart;
import com.casestudy.CartService.entity.Items;
//import com.casestudy.CartService.entity.JwtUtil;
import com.casestudy.CartService.entity.Product;
//import com.casestudy.CartService.entity.User1;
import com.casestudy.CartService.repository.CartRepository;
//import com.casestudy.CartService.repository.UserRepository;
import com.casestudy.CartService.service.CartService;
import com.casestudy.CartService.service.CartServiceImpl;
//import com.casestudy.CartService.service.MyUserDetailsService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class CartController {

//	@Autowired
//	private AuthenticationManager authenticationManager;
//	@Autowired
//	private MyUserDetailsService userDetailsService;
//	@Autowired
//	private JwtUtil jwtTokenUtil;
//	@Autowired
//	UserRepository repo;
	
	@Autowired
	CartService cartService;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartServiceImpl cartServiceImpl;

	Logger logger = LoggerFactory.getLogger(CartController.class);

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	public CartController() {

	}

	@GetMapping("/getallcarts")
	public ResponseEntity<List<Cart>> getAllCarts() {
		logger.info("Get All Carts methods for the Cart from the controller");
		return ResponseEntity.ok(cartServiceImpl.getallcarts());
	}

	@PostMapping("/addingproducttocart/{cartId}/{productId}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable String cartId, @PathVariable int productId) {
		Product product = restTemplate.getForObject("http://product-service/product/findById/" + productId,
				Product.class);
		logger.info("Products added to this cart is: " + product);
		logger.info("Condition to check whether the cartid given is already present or not");
		if (cartRepository.existsById(cartId)) {
			Cart oldCart = cartRepository.findById(cartId).get();
			List<Integer> idList = new ArrayList<>();
			List<Items> oldItem3 = oldCart.getItems();
			for (Items i : oldItem3) {
				idList.add(i.getProductId());
			}
			logger.info("List already contains product then add into the list condition");
			if (idList.contains(product.getProductId())) {
				logger.info("in if method");
				List<Items> oldItem2 = oldCart.getItems();
				logger.info("Checking the productId match");
				for (Items i : oldItem2) {
					if (i.getProductId() == productId) {
						i.setQuantity(i.getQuantity() + 1);
					}
				}
				double price = 0;
				logger.info("Calculation the price with the new conditions");
				for (Items i : oldItem2) {
					price = price + i.getPrice() * i.getQuantity();
				}
				oldCart.setTotalPrice(price);
				return new ResponseEntity<>(cartServiceImpl.addCart(oldCart), HttpStatus.CREATED);
			} else {
				logger.info("Else condition if there is no products in the list");
				Items items = new Items();
				items.setProductId(productId);
				items.setPrice(product.getPrice());
				items.setProductName(product.getProductName());
				items.setQuantity(1);
				items.setImages(product.getImages());
				List<Items> oldItems = oldCart.getItems();
				oldItems.add(items);
				oldCart.setItems(oldItems);
				double price = 0;
				for (Items i : oldItems) {
					price = price + i.getPrice() * i.getQuantity();
				}
				oldCart.setTotalPrice(price);
				return new ResponseEntity<>(cartServiceImpl.addCart(oldCart), HttpStatus.CREATED);
			}
		} else {
			logger.info("Or else if the cartid is not there creating new cart condition");
			Cart cart = new Cart();
			cart.setCartId(cartId);
			Items items = new Items();
			items.setProductId(productId);
			items.setPrice(product.getPrice());
			items.setProductName(product.getProductName());
			items.setQuantity(1);
			items.setImages(product.getImages());
			List<Items> list = new ArrayList<>();
			list.add(items);
			cart.setItems(list);
			double price = 0;
			for (Items i : list) {
				price = price + i.getPrice() * i.getQuantity();
			}
			cart.setTotalPrice(price);
			return new ResponseEntity<>(cartRepository.save(cart), HttpStatus.CREATED);

		}
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable String cartId) {
		logger.info("Get Cart By Id method from the controller");
		return new ResponseEntity<>(cartServiceImpl.getCartById(cartId), HttpStatus.CREATED);
	}

	@PutMapping("/delete/item/{productId}/{cartId}")
	public Cart deleteCartItem(@PathVariable String cartId, @PathVariable int productId) {
		Product product = restTemplate.getForObject("http://product-service/product/findById/" + productId,
				Product.class);
		logger.info("Product added to this cart" + product);
		Cart cart2 = cartServiceImpl.getCartById(cartId);
		List<Items> list = new ArrayList<>();
		list = cart2.getItems();
		System.out.println(list);
		list.removeIf(i -> (i.getProductId() == productId));
		cart2.setItems(list);
		double price = 0;
		logger.info("Product is reomoved from the cart and the price is recalculated");
		for (Items i : list) {
			price = price + i.getPrice() * i.getQuantity();

		}
		cart2.setTotalPrice(price);
		return cartServiceImpl.updateCart(cart2.getCartId(), cart2);
	}

	@PutMapping("/decreaseQuant/{productId}/{cartId}")
	public Cart decreaseItem(@PathVariable int productId, @PathVariable String cartId) {
		Cart cart = cartServiceImpl.getCartById(cartId);
		List<Items> oldItem3 = cart.getItems();
		logger.info("Condition to check whether the product id is matching and decreasing the quantity");
		for (Items i : oldItem3) {
			if (i.getProductId() == productId) {
				i.setQuantity(i.getQuantity() - 1);
			}
		}
		double price = 0;
		logger.info("After the product id is matched and the quantity has been decreased price calculation");
		for (Items i : oldItem3) {
			price = price + i.getPrice() * i.getQuantity();
		}
		cart.setTotalPrice(price);
		return cartServiceImpl.updateCart(cartId, cart);
	}
	
	@PutMapping("/increaseQuant/{productId}/{cartId}")
	public Cart increaseItem(@PathVariable int productId, @PathVariable String cartId) {
		Cart cart = cartServiceImpl.getCartById(cartId);
		List<Items> oldItem3 = cart.getItems();
		logger.info("Condition to check whether the product id is matching and decreasing the quantity");
		for (Items i : oldItem3) {
			if (i.getProductId() == productId) {
				i.setQuantity(i.getQuantity() + 1);
			}
		}
		double price = 0;
		logger.info("After the product id is matched and the quantity has been decreased price calculation");
		for (Items i : oldItem3) {
			price = price + i.getPrice() * i.getQuantity();
		}
		cart.setTotalPrice(price);
		return cartServiceImpl.updateCart(cartId, cart);
	}

	@DeleteMapping("/delete/{cartId}")
	public void deleteCart(@PathVariable String cartId) {
		logger.info("Deleting the entire cart");
		cartServiceImpl.deleteCartById(cartId);
	}


}

