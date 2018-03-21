package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UnitOfMeasurement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uomID;
	private String description;

	/*@OneToOne
	private Ingredient ingredient;
*/
	public Long getUomID() {
		return uomID;
	}

	public void setUomID(Long uomID) {
		this.uomID = uomID;
	}

	/*public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
