package com.example.demo.commands;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

import com.example.demo.model.Category;
import com.example.demo.model.Difficulty;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Notes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
	private Long recipeID;

	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String url;

	private String directions;
	private String description;

	private NotesCommand notes;

	private Set<IngredientCommand> ingredient = new HashSet<>();

	private Difficulty difficulty;

	public Set<CategoryCommand> categories = new HashSet<>();
}
