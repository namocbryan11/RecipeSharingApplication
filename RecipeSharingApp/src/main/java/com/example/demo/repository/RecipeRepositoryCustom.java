package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipe;

@Repository
public interface RecipeRepositoryCustom {
	List<Recipe>getAllRecipe();
	void updateRecipe(String name, int Id);
}
