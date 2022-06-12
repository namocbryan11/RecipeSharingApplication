package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Recipe;

@RestController
public class RecipeMethods {
	
	Recipe recipe = new Recipe();
	static List<Recipe> recipes = new ArrayList<Recipe>();
	
	static {
		recipes.add(new Recipe("Humba","Lami",0));
		recipes.add(new Recipe("Afritada","Way Lami",0));
	}
	
	public List<Recipe> getRecipes(){
		return recipes;
	}
	
	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
	}
}
