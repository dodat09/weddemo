package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Service.CartService;
@Service
public class CartServiceImpl implements CartService{
  
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public List<Cart> getAllCart() {
		List<Cart> getAllCart = cartRepo.findAll();	
		return getAllCart;
	}

	@Override
	public void addToCart(Cart cart) {
		cartRepo.save(cart);
		
	}

	@Override
	public void removeCart(int cartid) {
		cartRepo.deleteById(cartid);
		
	}

	@Override
	public void updateCart(Product product, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
