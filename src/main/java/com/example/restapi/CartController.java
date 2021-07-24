package com.example.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;

	@GetMapping("/get")
	public List<CartItem> getCartDetails() {
		return cartService.getCartDetails();
	}
	
	@PostMapping("/add")
	public int addCartDetails(@RequestBody CartItem cartItem) {
		return cartService.addCartDetails(cartItem);
	}
	
	@PutMapping("/update")
	public int updateCartDetails(@RequestBody CartItem cartItem) {
		return cartService.updateCartDetails(cartItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public int deleteCartDetails(@PathVariable int id) {
		return cartService.deleteCartDetails(id);
	}
}
