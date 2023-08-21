package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.Impl.CateServiceImpl;
import com.example.demo.Service.Impl.ProductServiceImpl;

@RestController
@RequestMapping("/")
public class ProductApi {

	@Autowired
	private CateServiceImpl cateService;
	@Autowired
	private ProductServiceImpl productService;
	
//láy tất cả các product có trong database ra ngoài
	@GetMapping("/getAllProduct")
	public String getAll(Model model) {
		List<Product> listProduct=productService.getAllProduct();
		int size= listProduct.size();
		model.addAttribute("size", size);
		model.addAttribute("list", listProduct);
		return "shop";
	}
 // lấy list Product thông qua color
	@GetMapping("/getproductbycolor")
	public String getProductByColor(@RequestParam("color") String color,Model model) {
         List<Product> listProduct=productService.getProductByColor(color);
          model.addAttribute("list", listProduct);
	      return "shop";
	}
	//lấy list Product thông qua Size
	@GetMapping("/getproductbysize")
	public String getProductBySize(@RequestParam("size") String size,Model model) {
		List<Product> listProduct=productService.getProductBySize(size);
		model.addAttribute("list", listProduct);
		return "shop";
	}
	
// lấy list Product dụa theo price
	@GetMapping("/getproductbyprice")
	public String getProductByPrice(@RequestParam("start") int start,@RequestParam("end") int end,Model model) {
		List<Product> listProduct= productService.getProductByPrice(start, end);
		model.addAttribute("list",listProduct);
		return "shop";
	}
	}