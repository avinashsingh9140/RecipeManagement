package com.recipeManagement.recipe_Management.Repo;

import com.recipeManagement.recipe_Management.Model.Admin;
import com.recipeManagement.recipe_Management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo  extends JpaRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String newEmail);
}
