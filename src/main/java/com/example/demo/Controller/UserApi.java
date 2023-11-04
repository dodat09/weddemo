package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Service.Impl.UserServiceImpl;

@Controller
@RequestMapping(name="/")
@Transactional
public class UserApi {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/login")
	public String loginUser(Model model) {	
		
		return "login";
	}
@PostMapping("/change_password")
public String updatePassword(@RequestParam("newpassword") String newpassword,@RequestParam("confirmpassword") String confirmpassword,@ModelAttribute("toemail")String toemail,Model model) {
     if(!newpassword.equals(confirmpassword)) {
    	 String error="confirmpasswrod nhập khác so với password";
    	 model.addAttribute("error", error);
    	 return "newpassword";
     }else {
			User user = userService.findByEmail(toemail);
     PasswordEncoder encoder = new BCryptPasswordEncoder();
     userService.updatePasswordByEmail(encoder.encode(newpassword),user.getUid());
	System.out.println(toemail);
	System.out.println(user.getUid());
	return "login";
     }

}
	
	
}
