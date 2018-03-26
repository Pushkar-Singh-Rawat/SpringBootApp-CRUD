package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.commands.RecipeCommand;
import com.example.demo.services.RecipeService;

@Controller
public class RecipeController {

	private RecipeService recipeService;

	@Autowired // just to indicate that springcontext injects RecipeServiceImpl
				// object here
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/{id}/show") // setting up MVC.
	public String showById(Model model, @PathVariable String id) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		return "recipe/show";
	}

	@RequestMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}

	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand command) {
		// @ModalAttribute grabs any post object present in the "recipe" path.
		RecipeCommand savedRecipe = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/" + savedRecipe.getRecipeID()+"/show";
	}
	
	
}
