package com.recipeManagement.recipe_Management.Service;

import com.recipeManagement.recipe_Management.Model.Token.AuthenticationToken;
import com.recipeManagement.recipe_Management.Repo.AuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    @Autowired
    AuthTokenRepo authTokenRepo;

    public void createToken(AuthenticationToken token) {
        authTokenRepo.save(token);
    }


    public boolean authenticate(String email, String tokenVal) {
        AuthenticationToken token =  authTokenRepo.findFirstByTokenValue(tokenVal);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }else
        {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {
        AuthenticationToken token =  authTokenRepo.findFirstByTokenValue(tokenValue);
        authTokenRepo.delete(token);
    }
}
