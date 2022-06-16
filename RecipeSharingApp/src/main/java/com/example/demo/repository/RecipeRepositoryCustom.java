package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipe;

@Repository
public interface RecipeRepositoryCustom {
	List<Recipe>getAllRecipe();
	void updateRecipe(Recipe recipe, int Id);
	Recipe createRecipe(Recipe recipe);
	void deleteRecipe(int Id);
}
