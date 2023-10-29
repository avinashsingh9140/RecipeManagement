package com.recipeManagement.recipe_Management.Service;

import com.recipeManagement.recipe_Management.Model.Admin;
import com.recipeManagement.recipe_Management.Model.User;
import com.recipeManagement.recipe_Management.Repo.AdminRepo;
import com.recipeManagement.recipe_Management.Service.PasswordEncryptor.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    public String addAdmin(Admin newAdmin) {

        String newEmail = newAdmin.getAdminEmail();

        Admin existingAdmin = adminRepo.findFirstByAdminEmail(newEmail);

        if (existingAdmin != null) {
            return existingAdmin.getAdminEmail() + " is already in use. Please try with a different email.";
        } else {
            String signUpPassword = newAdmin.getAdminPassword();

            try {
                String encryptedPassword = PasswordEncrypt.encrypt(signUpPassword);
                newAdmin.setAdminPassword(encryptedPassword);
                adminRepo.save(newAdmin);
                return newAdmin.getAdminName() + " has been registered successfully as an Admin.";
            }
            catch (NoSuchAlgorithmException e) {
                return "Internal Server Error while saving the password. Please try again later.";
            }
        }
    }
}
