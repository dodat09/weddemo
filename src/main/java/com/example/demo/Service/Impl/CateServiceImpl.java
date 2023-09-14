package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.Service.CategoryService;
@Service
public class CateServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public List<Category> getAllCategory() {
		List<Category> cate= categoryRepo.findAll();
		return cate;
	}

}
