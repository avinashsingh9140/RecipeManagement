package com.recipeManagement.recipe_Management.Repo;

import com.recipeManagement.recipe_Management.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

    Recipe getRecipeByRecipeId(Integer recipeId);

    boolean existsByRecipeId(Integer id);
}
