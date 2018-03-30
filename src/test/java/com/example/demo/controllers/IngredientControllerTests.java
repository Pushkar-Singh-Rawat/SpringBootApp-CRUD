package com.example.demo.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;

import com.example.demo.services.IngredientService;
import com.example.demo.services.RecipeService;

public class IngredientControllerTests {
	MockMvc mockMVC;
	IngredientController ingredientController;
	@Mock
	RecipeService recipeService;
	@Mock
	IngredientService ingredientService;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ingredientController = new IngredientController(recipeService,ingredientService);
		mockMVC = MockMvcBuilders.standaloneSetup(ingredientController).build();
	}

	@Test
	public void testShowIngredient() throws Exception {

		mockMVC.perform(get("/recipe/1/ingredients/2/show/")).andExpect(status().isOk())
				.andExpect(view().name("recipe/ingredient/show"))
				/*.andExpect(MockMvcResultMatchers.model().attributeExists("ingredient"))*/;

	}
}