package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.IngredientService;
import com.example.demo.services.RecipeService;

@Controller
public class IngredientController {

	private RecipeService recipeService;
	private IngredientService ingredientService;

	@Autowired // just to indicate that springcontext injects RecipeServiceImpl
				// object here
	public IngredientController(RecipeService recipeService,IngredientService ingredientService) {
		this.recipeService = recipeService;
		this.ingredientService=ingredientService;
	}

	@GetMapping
	@RequestMapping("/recipe/{id}/ingredients") // setting up MVC.
	public String ListIngredients(Model model, @PathVariable String id) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		return "recipe/ingredient/list";
	}
	@GetMapping
	@RequestMapping("/recipe/{recipeid}/ingredients/{ingredientid}/show/") // setting up MVC.
	public String showById(Model model, @PathVariable String recipeid,
			@PathVariable String ingredientid) {
		
		model.addAttribute("ingredient",ingredientService.findByRecipeIdAndIngredientID(Long.valueOf(recipeid),Long.valueOf(ingredientid)));
		return "recipe/ingredient/show";
	}
	
	
	
}
