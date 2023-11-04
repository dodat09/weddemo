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
import com.example.demo.Service.Impl.CateServiceImpl;
import com.example.demo.Service.Impl.ProductServiceImpl;

@Controller
@RequestMapping(name="/")
public class CategoryApi {

	@Autowired
	private CateServiceImpl categoryService;
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/home")
	public String  getAllCategory(Model model){
//		ModelAndView modelAndView= new ModelAndView();
//		modelAndView.setViewName("index");
		List<Category> list= categoryService.getAllCategory();
		List<Product> listProduct= productService.getAllProduct();
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		model.addAttribute("authentication", authentication);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listCategory", list);
		
		return "index";
	}
	@GetMapping("/productbycid")
	public String getProductByCid(@RequestParam("cid")int cid,Model model) {
//		ModelAndView modelandview = new ModelAndView();
//		modelandview.setViewName("shop");
		List<Product> listProduct= productService.getProductByCid(cid);
		List<Category> listCategory= categoryService.getAllCategory();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("list", listProduct);
		return "shop";
	}
	
	
	
}
