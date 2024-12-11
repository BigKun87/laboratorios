package com.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {


	
	@GetMapping(value = {"/","/login"})
	public String getLogin() {
		return "/private/login/login";
	}
	
	@GetMapping("/admin")
	public String getAdminPanel() {
		return "admin";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}
	
	

}
