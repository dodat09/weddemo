package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.Impl.CateServiceImpl;
import com.example.demo.Service.Impl.ProductServiceImpl;

@RestController
@RequestMapping(name="/")
public class CategoryApi {

	@Autowired
	private CateServiceImpl categoryService;
	@Autowired
	private ProductServiceImpl productService;
}
