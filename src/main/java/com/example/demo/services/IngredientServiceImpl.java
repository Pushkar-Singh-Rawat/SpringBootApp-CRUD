package com.example.demo.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commands.IngredientCommand;
import com.example.demo.converters.IngredientToIngredientCommand;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import com.example.demo.respositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

	RecipeRepository recipeRepository;
	IngredientToIngredientCommand ingredientToIngredientCommand;
	@Autowired //just to mark that via constructor we are performing DI
	public IngredientServiceImpl(RecipeRepository recipeRepository,IngredientToIngredientCommand ingredientToIngredientCommand) {
		super();
		this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand=ingredientToIngredientCommand;
	}
    
	@Override
	public Ingredient findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngredientCommand findByRecipeIdAndIngredientID(Long recipeid, Long ingredientid) {

		Optional<Recipe> recipeOptional=recipeRepository.findById(recipeid);

		if(!recipeOptional.isPresent()){
			log.error("recipe corresponding to"+ recipeid+" is not present");
		}
		Optional<IngredientCommand> ingredientOptional=recipeOptional.get().getIngredient().stream()
				.filter(ingredient->ingredient.getIngredientID().equals(ingredientid))
				.map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
		
		if(!ingredientOptional.isPresent()){
			log.error("ingredient with id "+ingredientid+" is not present");
		}
		
		/*Optional<Recipe> recipe=recipeRepository.findById(Long.valueOf(recipeid));
		Set<Ingredient> ingredientC=recipe.get().getIngredient();
		for(Ingredient ingred:ingredient){
			if(ingred.getIngredientID().equals(Long.valueOf(ingredientid))){
				return ingred;
			}
		}*/
		return ingredientOptional.get();
	}



}
