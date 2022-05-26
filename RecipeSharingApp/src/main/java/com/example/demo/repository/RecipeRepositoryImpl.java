package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipe;

@Repository
public class RecipeRepositoryImpl implements RecipeRepositoryCustom{
	
//	@PersistenceContext
//	private EntityManager entityManager;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Recipe> getAllRecipe() {
		String sql = "SELECT * FROM RECIPES ORDER BY ID";
		List<Recipe> recipe = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Recipe.class));
		return recipe;
	}
	//this.jdbcTemplate.update("UPDATE RECIPES set NAME = ? WHERE ID = ?", name,Id);

	@Override
	public Recipe createRecipe(Recipe recipe) {
		String name= recipe.getName();
		String description= recipe.getDescription();
		int vote = recipe.getVote();
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("INSERT INTO RECIPES(NAME,DESCRIPTION,VOTES) VALUES(?,?,?)",name,description,vote);
		return recipe;
	}

	@Override
	public void updateRecipe(Recipe recipe, int Id) {
		// TODO Auto-generated method stub
		String name = recipe.getName();
		String description = recipe.getDescription();
		int vote = recipe.getVote();
		this.jdbcTemplate.update("UPDATE RECIPES set NAME=?, DESCRIPTION=?, VOTES=? WHERE ID=?", name,description,vote,Id);
	}

	@Override
	public void deleteRecipe(int Id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("DELETE from RECIPES WHERE ID = ?", Id);
		
	}

	
	
/* Use <Object[]> instead of <Recipe> if you want to get specific columns from the table only
 * example the table has these columns (id,name,description,votes)
 * but you only need name and description. <Object[]>  is advisable in this case
*/
//	@Override
//	public List<Object[]> getAllRecipe() {
//		String sql = "SELECT r FROM Recipe r WHERE r.id = 1";
//		List<Object[]> list = entityManager.createQuery(sql).getResultList();
//		return list;
//	}

}
