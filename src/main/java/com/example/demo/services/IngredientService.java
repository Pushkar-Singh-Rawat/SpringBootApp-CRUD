package com.example.demo.services;




import com.example.demo.commands.IngredientCommand;
import com.example.demo.model.Ingredient;

public interface IngredientService{

	Ingredient findById();

	IngredientCommand findByRecipeIdAndIngredientID(Long recipeID, Long ingredientID);
	
}
