package com.recipeManagement.recipe_Management.Service;


import com.recipeManagement.recipe_Management.Model.Comment;
import com.recipeManagement.recipe_Management.Model.Recipe;
import com.recipeManagement.recipe_Management.Model.User;
import com.recipeManagement.recipe_Management.Repo.CommentRepo;
import com.recipeManagement.recipe_Management.Repo.RecipeRepo;
import com.recipeManagement.recipe_Management.Repo.UserRepo;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;


    // ******  --- Add Comment on Recipe ---  ***** //
    public void addComment(Comment newComment) {
        commentRepo.save(newComment);
    }

    public Comment findCommentById(Integer commentId) {
        return commentRepo.findById(commentId).orElseThrow();
    }

    public void removeCommentById(Integer commentId) {
        commentRepo.deleteById(commentId);
    }
}
