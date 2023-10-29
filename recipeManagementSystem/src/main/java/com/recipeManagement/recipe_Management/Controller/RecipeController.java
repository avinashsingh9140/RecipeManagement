package com.recipeManagement.recipe_Management.Controller;

import com.recipeManagement.recipe_Management.Model.Recipe;
import com.recipeManagement.recipe_Management.Service.CommentService;
import com.recipeManagement.recipe_Management.Service.RecipeService;
import com.recipeManagement.recipe_Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    // ************  -- Add Recipe -- ************ //
    @PostMapping("add/recipe")
    public String addRecipe(@RequestBody Recipe addNewRecipes, @RequestParam String email, @RequestParam String tokenVal) {
         return recipeService.addRecipe(addNewRecipes, email, tokenVal);
    }

    // ************  -- Get All Recipe -- ************ //
    @GetMapping("get/recipe")
    public List<Recipe> getAllRecipes(@RequestParam String email, @RequestParam String tokenVal) {
        return recipeService.getAllRecipes(email, tokenVal);
    }

    // ************  --Get Recipe By ID -- ************ //
    @GetMapping("getAll/recipe/id/{id}")
    public Optional<Recipe> getAllRecipes(@RequestParam String email, @RequestParam String tokenVal, @RequestParam Integer recipeId) {
        return recipeService.getRecipesById(email, tokenVal, recipeId);
    }


    // ************  -- Update Recipe -- ************ //
    @PutMapping("update/recipe")
    public String  updateRecipes(@RequestParam String email, @RequestParam String tokenVal, @RequestBody Recipe updateRecipe){
        return  recipeService.updateRecipes(email, tokenVal, updateRecipe);
    }

    // ************  -- Delete Recipe By ID -- ************ //
    @DeleteMapping("delete/recipe/id/{id}")
    public String deleteRecipe(@RequestParam String email, @RequestParam String tokenVal, @PathVariable Integer id){
        return recipeService.deleteRecipe(email, tokenVal, id);
    }



    // ************  -- Add  Comment -- ************ //
    @PostMapping("/comment/recipe/{recipeId}")
    public String addCommentOnRecipe(@RequestParam String email, @RequestParam String tokenVal,
                                     @RequestBody String commentBody, @PathVariable Integer recipeId )
    {
        return userService.addCommentOnRecipe(email,tokenVal,commentBody,recipeId);
    }



        // ************  -- Remove  Comment -- ************ //
        @DeleteMapping("/recipe/comment/{commentId}")
        public String removeComment(@RequestParam String email, @RequestParam String tokenVal,
                                    @PathVariable Integer commentId)
        {
            return userService.removeComment(email,tokenVal,commentId);
        }
}
