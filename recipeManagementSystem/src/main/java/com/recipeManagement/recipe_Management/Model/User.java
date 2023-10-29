package com.recipeManagement.recipe_Management.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.recipeManagement.recipe_Management.Model.Enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=User.class,property="userId")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotBlank(message = " Please Enter Your UserName!!")
    private String userName;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Size(min = 10 , max = 13, message = "Please Enter Valid Phone Number!!")
    private String phoneNumber;
    @Email(message = "Please Enter Valid Mail ID")
    private String userEmail;
 
  // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*])[A-Za-z\\d@#$%!^&*]{8,}$", message = " Requires at least one lowercase letter, at least one uppercase letter,  at least one digit and at least one special character!!")
    private String userPassword;
    @NotBlank
    private String userAddress;

    @OneToMany(mappedBy = "user")
    List<Recipe> recipes;
}
