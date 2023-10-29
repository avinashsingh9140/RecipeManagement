package com.recipeManagement.recipe_Management.Controller;


import com.recipeManagement.recipe_Management.Model.DTO.SignInAuthentication;
import com.recipeManagement.recipe_Management.Model.User;
import com.recipeManagement.recipe_Management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // ******  -- User SignUp  --  ****** //
    @PostMapping("SignUp")
    public String addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    // ******  -- User SignIn  --  ****** //
    @PostMapping("SignIn")
    public String userSignIn(@Valid @RequestBody SignInAuthentication user) {
        return userService.userSignIn(user);
    }


    // ******  -- User SignOut  --  ****** //
    @DeleteMapping("SignOut")
    public String userSignOut(@RequestParam String email, @RequestParam String tokenVal) {
        return userService.userSignOut(email, tokenVal);
    }

}
