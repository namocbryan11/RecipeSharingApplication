package com.example.demo.controller.jsp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeMethods;


@Controller
@RequestMapping("/jsp")
public class jsp_AddRecipe {
	
	Recipe recipe = new Recipe();
	
	@Autowired
	RecipeMethods recipeMethods;
	
	@GetMapping("/newrecipe")
	public String newRecipe() {
		return "NewRecipe";
	}
	
	@PostMapping("/newrecipe")
	public void newRecipe(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		recipe = new Recipe(name,description,0);
		recipeMethods.addRecipe(recipe);
		response.sendRedirect("/jsp/welcome");
	}
}
