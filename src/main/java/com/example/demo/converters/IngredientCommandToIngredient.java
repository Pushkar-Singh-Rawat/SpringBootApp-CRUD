package com.example.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.commands.IngredientCommand;
import com.example.demo.model.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
	private final UnitOfMeaurementCommandToUnitOfMesurement uomConverter;

	public IngredientCommandToIngredient(UnitOfMeaurementCommandToUnitOfMesurement uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Override
	public Ingredient convert(IngredientCommand source) {
		// TODO Auto-generated method stub
		if (source == null) {
			return null;
		}
		Ingredient ingredient = new Ingredient();
		ingredient.setAmount(source.getAmount());
		ingredient.setDescription(source.getDescription());
		ingredient.setIngredientID(source.getIngredientID());

		ingredient.setUnitOfMeasurement(uomConverter.convert(source.getUnitOfMeasurement()));
		return ingredient;
	}

}
