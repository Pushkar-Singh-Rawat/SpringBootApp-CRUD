package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.demo.controllers.HomeController;
import com.example.demo.model.Recipe;
import com.example.demo.services.RecipeService;

public class HomeControllerTest {

	@Mock
	RecipeService recipeService;
	HomeController homeController;
	@Mock
	Model model; // mocked Model interface

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		homeController = new HomeController(recipeService);

	}

	@Test
	public void getHome() {
		String homePageNameActual = homeController.getHome(model);
		String homePageNameExpected = "homePage";
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setRecipeID(1L);
		recipes.add(recipe);

		when(recipeService.getRecipe()).thenReturn(recipes);
		assertEquals(homePageNameExpected, homePageNameActual);

		verify(recipeService, times(1)).getRecipe();
		verify(model, times(1)).addAttribute("recipes", recipeService.getRecipe());
		/*
		 * verify(recipeService,times(0)).getRecipe();
		 * verify(recipeService,times(2)).getRecipe();
		 */

	}
}
