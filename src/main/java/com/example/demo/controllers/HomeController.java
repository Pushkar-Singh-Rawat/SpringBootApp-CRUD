package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Category;
import com.example.demo.model.UnitOfMeasurement;
import com.example.demo.respositories.CategoryRepository;
import com.example.demo.respositories.UnitOfMeasurementRepository;

@Controller //this class now a bean and will be picked up by default spring package scan.
public class HomeController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasurementRepository unitOfMeasurementRepository;
	
	public HomeController(CategoryRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasurementRepository = unitOfMeasurementRepository;
	}
	

	@RequestMapping({"","/","/home"}) //setting up MVC.
	public String getHome() {
		Optional<Category> optCategory=categoryRepository.findByDescription("Indian");
		Optional<UnitOfMeasurement> optUnitOfMeasurement=unitOfMeasurementRepository.findByDescription("Tablespoon");
		System.out.println(optCategory.get().getCatgID());
		System.out.println(optUnitOfMeasurement.get().getUomID());
		return "homePage";   //spring will pick Thymeleaf template with name homePage;
	}
}
