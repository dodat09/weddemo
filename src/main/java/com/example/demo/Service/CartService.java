package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;

public interface CartService {
 public List<Cart> getAllCart();
  
  public void addToCart(Cart cart);
  
  public void removeCart(int cartid);
  
  public void updateCart(Product product,int quantity);
}
