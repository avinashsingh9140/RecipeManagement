package com.recipeManagement.recipe_Management.Service;

import com.recipeManagement.recipe_Management.Model.Recipe;
import com.recipeManagement.recipe_Management.Repo.AuthTokenRepo;
import com.recipeManagement.recipe_Management.Repo.CommentRepo;
import com.recipeManagement.recipe_Management.Repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    AuthTokenService authTokenService;

    @Autowired
    AuthTokenRepo authTokenRepo;

    @Autowired
    CommentRepo commentRepo;

   //     -----  Add Recipe -----  //
    public String addRecipe(Recipe addNewRecipes, String email, String tokenVal) {
        if(authTokenService.authenticate(email, tokenVal)) {
           recipeRepo.save(addNewRecipes);
            return "New Recipe Added Successfully!!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    //     -----  Get Recipe -----  //
    public List<Recipe> getAllRecipes(String email, String tokenVal) {
        if(authTokenService.authenticate(email, tokenVal)) {
            return recipeRepo.findAll();
        }
        return  null;
    }

    //     -----  Update Recipe -----  //
    public String updateRecipes(String email, String tokenVal, Recipe updateRecipe) {
        if(authTokenService.authenticate(email, tokenVal)) {
            recipeRepo.save(updateRecipe);
            return "Recipe Updated Successfully!!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

        //     -----  Delete Recipe -----  //
    public String deleteRecipe(String email, String tokenVal, Integer id) {
        if (authTokenService.authenticate(email, tokenVal)) {
            if (recipeRepo.existsByRecipeId(id)) {
                recipeRepo.deleteById(id);
                return "Recipe Deleted Successfully!!!";
            } else {
                return "Recipe with ID " + id + " does not exist!!!";
            }
        }
        return "Unauthenticated Access!! Please Login First!!!";
    }

    public Optional<Recipe> getRecipesById(String email, String tokenVal, Integer recipeId) {
        if(authTokenService.authenticate(email, tokenVal)){
                return recipeRepo.findById(recipeId);
        }
        return null;
    }


}
