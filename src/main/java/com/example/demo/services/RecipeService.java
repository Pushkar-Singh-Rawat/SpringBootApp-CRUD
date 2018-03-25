package com.example.demo.services;

import java.util.Set;

import com.example.demo.commands.RecipeCommand;
import com.example.demo.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipe();

	Recipe findById(long l);

	RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
