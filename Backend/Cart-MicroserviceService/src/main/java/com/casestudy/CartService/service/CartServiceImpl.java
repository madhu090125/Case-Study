package com.casestudy.CartService.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.casestudy.CartService.entity.Cart;
import com.casestudy.CartService.exception.CartNotFoundException;
import com.casestudy.CartService.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart getCartById(String cartId) throws CartNotFoundException {
		if (cartRepository.existsById(cartId)) {
			logger.info("Cart details of id exists " + cartId);
			return cartRepository.findById(cartId).get();
		} else {
			logger.warn("CART NOT FOUND WITH ID " + cartId);
			throw new CartNotFoundException("Cart id does not exists");
		}
	}

	@Override
	public Cart updateCart(String cartId, Cart cart) throws CartNotFoundException {
		logger.info("Condition to check whether the id is existing or not");
		if (cartRepository.existsById(cartId)) {
			Cart updatedCart = cartRepository.findById(cartId).get();
			updatedCart.setCartId(cart.getCartId());
			updatedCart.setItems(cart.getItems());
			updatedCart.setTotalPrice(cart.getTotalPrice());
			cartRepository.save(updatedCart);
			return updatedCart;

		} else {
			logger.warn("NO CART FOUND WITH ID " + cartId);
			throw new CartNotFoundException("NO CART FOUND WITH ID " + cartId);
		}

	}
//
	@Override
	public List<Cart> getallcarts() throws CartNotFoundException {
		logger.info("Getting all the carts method from the service implementation");
		List<Cart> carts = cartRepository.findAll();
		logger.info("Condition to check empty state");
		if (carts.isEmpty()) {
			logger.warn("Exception is caught NO CART EXISTS");
			throw new CartNotFoundException("NO CARTS EXISTS");
		} else {
			return carts;
		}
	}

//	@Override
//	public String deleteCartById(String cartId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public double cartTotal(Cart cart) {
		logger.info("Method to calculate the total price from the service implementation");
		return cart.getTotalPrice();
	}
//
	@Override
	public Cart addCart(Cart cart) {
		logger.info("Method to add new cart from the service implementation");
		return cartRepository.save(cart);
	}

	@Override
	public String deleteCartById(String cartId) {
		logger.info("Method to delete the existing cart from the service implementation");
		cartRepository.deleteById(cartId);
		return "Deleted Successfully";

    }

}


