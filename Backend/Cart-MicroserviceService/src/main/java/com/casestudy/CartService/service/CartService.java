package com.casestudy.CartService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.CartService.entity.Cart;

@Service
public interface CartService {
	public Cart getCartById(String cartId);

	public Cart updateCart(String cartId, Cart cart);

	public List<Cart> getallcarts();

	public double cartTotal(Cart cart);

	public Cart addCart(Cart cart);

	String deleteCartById(String cartId);

}
