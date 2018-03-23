package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.demo.controllers.HomeController;
import com.example.demo.services.RecipeService;

public class HomeControllerTest {

	@Mock
	RecipeService recipeService;
	HomeController homeController;
	@Mock
	Model model;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		homeController = new HomeController(recipeService);

	}

	@Test
	public void getHome() {
		
		assertEquals(homeController.getHome(model),"homePage");
		verify(recipeService,times(1)).getRecipe();
		verify(recipeService,times(0)).getRecipe();
		verify(recipeService,times(2)).getRecipe();
	}
}
