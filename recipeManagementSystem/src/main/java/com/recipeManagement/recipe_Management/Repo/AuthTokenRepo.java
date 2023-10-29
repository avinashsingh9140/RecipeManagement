package com.recipeManagement.recipe_Management.Repo;

import com.recipeManagement.recipe_Management.Model.Token.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);

}
