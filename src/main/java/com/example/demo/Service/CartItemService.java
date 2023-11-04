package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.User;

public interface CartItemService {
  List<CartItem> findCartByUid(User user);
  
  void addToCart(int productid);
  
}
