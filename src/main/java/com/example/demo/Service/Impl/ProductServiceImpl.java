package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
  
	@Autowired
	private ProductRepo  productRepo;
	@Override
	public List<Product> getAllProduct() {
		List<Product> listProduct = productRepo.findAll();
		return listProduct;
	}
	@Override
	public List<Product> getProductBySize(String size) {
		List<Product> list= productRepo.findProductBySize(size);
		return list;
	}
	@Override
	public List<Product> getProductByColor(String color) {
		List<Product> list = productRepo.findProducyByColor(color);
		return list;
		
	}
	@Override
	public List<Product> getProductByPrice(int start, int end) {
		List<Product > list= productRepo.findProductByPrice(start, end);
		return list;
	}
	@Override
	public List<Product> getProductByPname(String pname) {
	     List<Product> list=productRepo.findProductByPname(pname);	     
		return list;
	}
	@Override
	public Product getProductByPid(int pid) {
		Product product = productRepo.findOneProductByPid(pid);
		return product;
	}

}
