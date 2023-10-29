package com.recipeManagement.recipe_Management.Model.DTO;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AuthenticationInput {

    @Email
    private String email;
    private String tokenValue;
}
