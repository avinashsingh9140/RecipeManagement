package com.recipeManagement.recipe_Management.Service;

import com.recipeManagement.recipe_Management.Model.Comment;
import com.recipeManagement.recipe_Management.Model.DTO.SignInAuthentication;
import com.recipeManagement.recipe_Management.Model.Recipe;
import com.recipeManagement.recipe_Management.Model.Token.AuthenticationToken;
import com.recipeManagement.recipe_Management.Model.User;
import com.recipeManagement.recipe_Management.Repo.RecipeRepo;
import com.recipeManagement.recipe_Management.Repo.UserRepo;
import com.recipeManagement.recipe_Management.Service.Email_OTP_Sender.EmailSender;
import com.recipeManagement.recipe_Management.Service.PasswordEncryptor.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthTokenService authTokenService;

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    RecipeService recipeService;

    @Autowired
    CommentService commentService;


    // ***** --  User signUp  -- ***** //
    public String addUser(User newUser) {
        String newEmail = newUser.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            return existingUser.getUserEmail() + " Already in use try with new email!!!";
        }else {
            String signUpPassword = newUser.getUserPassword();

            try {
                String encryptedPassword = PasswordEncrypt.encrypt(signUpPassword);

                newUser.setUserPassword(encryptedPassword);

                userRepo.save(newUser);
                return newUser.getUserName() + " Registered Successfully!!!";

            } catch (NoSuchAlgorithmException e) {

                return "Internal Server issues while saving password, try again later!!!";
            }
        }
    }

    //   **************************** User SignUp End  ***************************** //

    // ***** --  User SignIn  -- ***** //
    public String userSignIn(SignInAuthentication user) {
        String email = user.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }
        String password = user.getUserPassword();

        try {
            String encryptedPassword = PasswordEncrypt.encrypt(password);

            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthenticationToken token  = new AuthenticationToken(existingUser);

                if(EmailSender.sendEmail(email,"OTP for Login ", token.getTokenValue())) {
                    authTokenService.createToken(token);
                    return "OTP sent successfully to " + existingUser.getUserEmail();
                }
                else {
                    return "error while generating token!!!";
                }
            }
            else {

                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }
    //   **************************** User Sign In End  ***************************** //

    // ***** --  User SignOut  -- ***** //
    public String userSignOut(String email, String tokenVal) {
        if(authTokenService.authenticate(email, tokenVal)) {
            authTokenService.deleteToken(tokenVal);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    //   **************************** User Sign out End  ***************************** //

    // ***** -- Get All User -- ***** //
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

//      //  ******  --  Add Comment  -- ******  //
    public String addCommentOnRecipe(String email, String tokenVal, String commentBody, Integer recipeId) {

        if(authTokenService.authenticate(email,tokenVal)) {
            //finding out the post which we are commenting
            Recipe recipeToBeCommented = recipeRepo.getRecipeByRecipeId(recipeId);
            //finding out commentor
            User commentor = userRepo.findFirstByUserEmail(email);

            // functionally more than 1 comment can be made on a particular post
            Comment newComment = new Comment(null,commentBody,
                    LocalDateTime.now(), recipeToBeCommented, commentor);

            commentService.addComment(newComment);

            return commentor.getUserName() + " commented on recipeId " + recipeId + " as follows" + commentBody +"!!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }
    //   **************************** Add Comment End  ***************************** //

//   //   ******   --  Remove Comment on Recipe  --  ******  //
    public String removeComment(String email, String tokenVal, Integer commentId) {
            if(authTokenService.authenticate(email,tokenVal)) {
                Comment comment = commentService.findCommentById(commentId);

                Recipe commentedOnRecipe = comment.getRecipe();
                if(authorizeCommentRemover(email,commentedOnRecipe,comment))
                {
                    commentService.removeCommentById(commentId);
                    return "comment deleted Successfully!!! ";
                }
                else {
                    return "Not authorized!!";
                }
            }
            else {
                return "Un Authenticated access!!!";
            }
    }

    private boolean authorizeCommentRemover(String email,Recipe commentedOnRecipe, Comment comment) {
        User potentialRemover = userRepo.findFirstByUserEmail(email);
        //only the commentor and the owner of the post should be allowed to remove a comment
        return potentialRemover.equals(commentedOnRecipe.getUser()) || potentialRemover.equals(comment.getCommenter());

    }

    //   ****************************  Remove Comment End  ***************************** //

}

