package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.Impl.CateServiceImpl;

@Controller
@RequestMapping(name="/")
public class DetailApi {

	@Autowired
	private CateServiceImpl cateService;
	@Autowired
	private ProductService productService;
	// lấy Product dựa vào pid
		@GetMapping("/detail")
		public String getProductByPid(@RequestParam("pid") int pid ,Model model) {
			Product product = productService.getProductByPid(pid);
			List<Category> listCategory= cateService.getAllCategory();
		 	model.addAttribute("listCategory", listCategory);
			model.addAttribute("product", product);
			return "detail";
		}
}
