package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.Impl.UserServiceImpl;

@Controller
@RequestMapping(name="/")
public class UserApi {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/login")
	public String loginUser(Model model) {
		String a = "hello";
		model.addAttribute("a", a);
		
		return "login";
	}
}
