package com.recipeManagement.recipe_Management.Repo;

import com.recipeManagement.recipe_Management.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


}
