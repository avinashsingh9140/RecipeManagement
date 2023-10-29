package com.recipeManagement.recipe_Management.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.recipeManagement.recipe_Management.Model.Enums.IngredientsType;
import com.recipeManagement.recipe_Management.Model.Enums.RecipeCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Recipe.class,property="recipeId")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    @NotBlank(message = "Please Enter Recipe Name! !!")
    private String recipeName;
    @Enumerated(value = EnumType.STRING)
    private RecipeCategory recipeCategory;  // veg or non veg
//    @Size(min = 1, message = "Please Enter at least 1 Quantity!!")
    private Integer recipeQuantity;
    @Enumerated(value = EnumType.STRING)
    private IngredientsType ingredients;
    @NotBlank
    private String instructions;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    User user;

}
