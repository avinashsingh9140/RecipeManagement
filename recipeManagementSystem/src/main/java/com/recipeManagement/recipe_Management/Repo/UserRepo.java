package com.recipeManagement.recipe_Management.Repo;

import com.recipeManagement.recipe_Management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


    User findFirstByUserEmail(String email);

}
