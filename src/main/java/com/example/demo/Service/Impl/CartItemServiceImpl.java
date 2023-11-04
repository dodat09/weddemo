package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDetail1;
import com.example.demo.Repository.CartItemRepo;
import com.example.demo.Service.CartItemService;
import com.example.demo.Service.ProductService;
@Service
public class CartItemServiceImpl implements CartItemService {

	
	@Autowired
	private CartItemRepo cartRepo;
	@Autowired
	private ProductServiceImpl productService;

	@Override
	public List<CartItem> findCartByUid(User user) {
		
		return cartRepo.findCartByUid(user.getUid());
	}

	@Override
	public void addToCart(int productid) {
		Product product = productService.getProductByPid(productid);
		
		
	}
	
	public User getCurrentUser(Authentication authentication) {
		if(authentication== null) return null;
		User user = null;
		Object pricipal = authentication.getPrincipal();
		if(pricipal instanceof UserDetail1) {
			user = ((UserDetail1) pricipal).getUser();
			
					}
		return user;
	}

}
