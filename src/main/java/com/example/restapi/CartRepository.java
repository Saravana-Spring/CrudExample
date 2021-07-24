package com.example.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<CartItem> getCartDetails() {
		return jdbcTemplate.query("select * from carts", 
				(rs, rowNum) -> 
					new CartItem(rs.getInt("id"), 
								 rs.getString("name"),
								 rs.getInt("price"))
				);
	}
	
	public int addCartDetails(CartItem cartItem) {
		return jdbcTemplate.update("insert into carts (id, name, price) values(?,?,)",
				cartItem.getId(), cartItem.getName(), cartItem.getPrice());
	}
	
	public int updateCartDetails(CartItem cartItem) {
		return jdbcTemplate.update("update carts set name = ? where id = ?",
				cartItem.getName(), cartItem.getId()
				);				
	}
	
	public int deleteCartDetails(int id) {
		return jdbcTemplate.update("delete carts where id = ?", id);
	}

}
