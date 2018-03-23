package com.example.demo.services;

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

import com.example.demo.model.Recipe;
import com.example.demo.respositories.RecipeRepository;

public class RecipeServiceTest {
	// test for service layer business logic
	// mockito will mock the respositoryclass
	// a pure junit test that leverages mockito mocks
	RecipeService recipeService;
	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this); // initiates the mock. mockito will return recipeRepository mock 
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void getRecipe() throws Exception{

		Recipe recipe=new Recipe();
		HashSet<Recipe> recipesSet=new HashSet<>();
		recipesSet.add(recipe);
		when(recipeService.getRecipe()).thenReturn(recipesSet);
		
		Set<Recipe> recipes = recipeService.getRecipe();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository,times(1)).findAll(); //findAll should be called only once as expected
	}
}
