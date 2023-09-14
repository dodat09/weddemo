package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Product;

public interface ProductService {
 List<Product> getAllProduct();
 
 List<Product> getProductBySize(String size);
 
 List<Product> getProductByColor(String color);
 
 List<Product> getProductByPrice(int start, int end);

 List<Product> getProductByPname(String pname);

 Product getProductByPid(int pid);
 
 List<Product> getProductByCid(int cid);
}
