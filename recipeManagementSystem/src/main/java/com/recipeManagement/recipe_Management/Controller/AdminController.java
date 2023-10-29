package com.recipeManagement.recipe_Management.Controller;

import com.recipeManagement.recipe_Management.Model.Admin;
import com.recipeManagement.recipe_Management.Model.User;
import com.recipeManagement.recipe_Management.Service.AdminService;
import com.recipeManagement.recipe_Management.Service.UserService;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

     //  ******  --  Register Admin  -- ******  //
    @PostMapping("Register")
    public String addAdmin(@RequestBody Admin newAdmin){
        return adminService.addAdmin(newAdmin);
    }

    //  ******  --  Get  All Users  -- ******  //
    @GetMapping("AllUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}

