package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;

@RestController
@RequestMapping("/api/")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	//get all recipe
	@GetMapping("/recipes")
	public List<Recipe> getAllRecipe()
	{
		System.out.print("Testing");
		System.out.print("Testing2");
		return recipeRepository.getAllRecipe();
	}
	@GetMapping("/recipes/{name}/{id}")
	public String updateRecipe(@PathVariable String name, @PathVariable int id) {
		try {
			recipeRepository.updateRecipe(name,id);
			return "Succesfully Changed!";
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
}
