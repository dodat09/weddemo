package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.User;
import com.example.demo.Service.Impl.CartItemServiceImpl;
import com.example.demo.Service.Impl.ProductServiceImpl;
import com.example.demo.Service.Impl.UserServiceImpl;

@Controller
@RequestMapping(name="/")
public class CartApi {

	@Autowired
	private CartItemServiceImpl cartService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired 
	private ProductServiceImpl productService;
	
	@GetMapping("/showcart")
	public String showCart(Model model,@AuthenticationPrincipal Authentication authentication) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentiAuthcation();
//		UserDetail1 userDetail = (UserDetail1) authentication.getPrincipal();
//		
//		System.out.println(userDetail);
		User user = cartService.getCurrentUser(authentication);
		
		List<CartItem> listCart= cartService.findCartByUid(user);
		model.addAttribute("listCart", listCart);
		return "cart";
	}
	@PostMapping("/addtocart")
	public String addToCart(Model model, @RequestParam("pid") int pid) {
		
		
		
		return "shop";
	}
}
