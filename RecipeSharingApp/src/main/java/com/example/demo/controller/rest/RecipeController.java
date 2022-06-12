package com.example.demo.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:8081/")
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
	
	@PostMapping("/recipes/update/{id}")
	public String updateRecipe(@RequestBody Recipe recipe, @PathVariable int id) {
		try {
			recipeRepository.updateRecipe(recipe,id);
			return "Succesfully Changed!";
		}catch(Exception e) {
			return e.getMessage();
		}
		 
	}
	//creating new recipe
	@PostMapping("/recipes")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		System.out.print("Recipe: "+ recipe.getDescription());
		return recipeRepository.createRecipe(recipe);
	}
	
	@PostMapping("/recipes/{id}")
	public boolean deleteRecipe(@PathVariable int id) {
		System.out.print("Id to delete: " + id);
		try {
			recipeRepository.deleteRecipe(id);
			return true;
		}catch(Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
		
	}
//	@PostMapping("/testing")
//	public Login login(@RequestParam(value="email", defaultValue="World") String email, 
//			@RequestParam(required=false) String password, Login login) {
//			login.setEmail(email);
//			login.setPassword(password);
//			return login;
//	}
	
}
