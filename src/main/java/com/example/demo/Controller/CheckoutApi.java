package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name="/")
public class CheckoutApi {

@GetMapping("/checkout")
public String checkOut() {
	return "checkout";
}

}
