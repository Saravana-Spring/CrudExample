package com.example.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	public List<CartItem> getCartDetails() {
		return cartRepository.getCartDetails();
	}
	
	public int addCartDetails(CartItem cartItem) {
		return cartRepository.addCartDetails(cartItem);
		
	}
	
	public int updateCartDetails(CartItem cartItem) {
		return cartRepository.updateCartDetails(cartItem);
	}
	
	public int deleteCartDetails(int id) {
		return cartRepository.deleteCartDetails(id);
	}
}
