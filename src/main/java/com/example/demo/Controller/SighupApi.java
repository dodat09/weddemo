package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.User;
import com.example.demo.Entity.DTO.UserDTO;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping(name="/")
public class SighupApi {
   
	@Autowired
	private UserService userService;
	
	
@GetMapping("/sighup")
 public String SighUp() {
//	 ModelAndView modelAndView = new ModelAndView();
//	 modelAndView.setViewName("sighup");
	 return "sighup";
 }
@GetMapping("/register")
public String getUser(Model model) {
	User user = new User();
	model.addAttribute("user", user);
	return "sighup";
}
@PostMapping("/register")
public String saveUser(@ModelAttribute("user") UserDTO userDto,Model model) {
	userService.saveUser(userDto);
	String message = "Bạn đã đăng kí thành công vui lòng đăng nhập";
	model.addAttribute("message", message);
	return "sighup";
}
// quên mat khẩu	
@GetMapping("/forgotpassword")
public String resetPassword() {
	return "forgotpassword";
}





}
