package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //this class now a bean and will be picked up by default spring package scan.
public class IndexController {

	@RequestMapping({"","/","/home"}) //setting up MVC.
	public String getHomePage() {
		return "homePage";   //spring will pick Thymeleaf template with name homePage;
	}
}
