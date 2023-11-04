package com.example.demo.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.Impl.JavaSendEmailImpl;

@Controller
@RequestMapping(name="/")
public class EmailSenderApi {
Random random = new Random();
private final static String subject="Lấy Mã Otp Để Đăng Nhập ";
private  String body = Integer.toString(random.nextInt(9000)+1000);

@Autowired
private JavaSendEmailImpl javaSendEmail;

@Autowired
private UserRepo userRepo;



@GetMapping("/send_email")
public String email() {
	return "inputemail";
}
@PostMapping("/send_email")
public String sendEmailTakeOtp(@RequestParam("toemail") String toemail,Model model) {
//	Random random = new Random();
//	int r = random.nextInt(9000)+1000;
//	body = Integer.toString(r);
//	model.addAttribute("otp", random);
	User user = userRepo.findUserByEmail(toemail);
	if(user==null) {
		String error = "email này chưa từng dc đăng kí";
		model.addAttribute("error", error);
		return "inputemail";
	}else {
		model.addAttribute("toemail", toemail);
	    javaSendEmail.sendEmail(toemail,subject,body);
	return "verifyotp";
	}
	
}
@PostMapping("/verifyOtp")
public String verifyOtp(@RequestParam("otp") String otp,@ModelAttribute("toemail") String toemail,Model model) {
	if(otp.equals(otp)) {
		model.addAttribute("toemail", toemail);
		return "newpassword";
	}else {
		model.addAttribute("error","sai otp");
		return "verifyotp";
	}
	
}
@GetMapping("/contact")
public String contactUser() {
	return "contact";
}

}
       
	


