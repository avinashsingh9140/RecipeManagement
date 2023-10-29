   ![Recipe-Management](https://lh3.googleusercontent.com/h3MPsQ6u1vqIZiuRQMjwDL9-8KmwXnyjZL2nfqHa3nowcBlW2lcJZoX2scVLW868U0ZaUWn-uiEBsNqeptfbt5-1oH-W15XJU9-uOMYzOPaSNuem2NiXX86DkdquPTeiaIYazkA0dMenf6oLTFjFItq58-Z_GxVQOGGOkCT3dgr231cEDXe7cNcuywxlew)
   
   ##### 🔸This is simple recipe management system built using Spring Boot framework. The idea was to build  a simple recipe management to perform basic CRUD operations                  with some validations and also auhentication.
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA-17
    3. Postman
    4. SQL
    5. Swagger
    
## :two: Dependency Used
    1. Spring Web
    2. Spring Boot Dev Tools
    3. Lombok
    4. Spring Data JPA
    5. MySQL Driver
    6. Validation
    7. Swagger
    9. Mail-Integration
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: Dataflow (Functions Used In)
### :white_flower: 1. Model - This used to show the mirror of our database which involves real world entities.
#### :o: AuthenticationToken.java
#### :o: User.java
#### :o: Admin.java
#### :o: Recipe.java
#### :o: RecipeCategory.java
#### :o: SignInAuthentication.java(DTO)

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :white_flower: 2. Service - This Layer is used to perform business functionalities.
#### :o: AdminService.java
#### :o: RecipeService.java
#### :o: AuthTokenService.java
#### :o: UserService.java


----------------------------------------------------------------------------------------------------------------------------------------------------

### :white_flower: 3. Controller - This Controller is used to create RestApi's and perform basic CRUD operations.
#### :o: AdminController.java
#### :o: RecipeController.java
#### :o: UserController.java

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :white_flower: 4. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: AdminRepo.java
#### :o: RecipeRepo.java
#### :o: AuthTokenRepo.java
#### :o: UserRepo.java

-------------------------------------------------------------------------------------------------------------------------------------------------------
### :white_flower: 5. Dto : Data transfer object
#### :o: Signup.java
#### :o: SignInInput.java
#### :o: SignOut.java
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: Test Rest Api's
#### :white_check_mark: User Controller
```java
http://localhost:8080/SignUp
```

```java
http://localhost:8080/SignIn
```

```java
http://localhost:8080/SignOut
```

#### :white_check_mark: Admin Controller
```java
http://localhost:8080/Register
```

```java
http://localhost:8080/AllUser
```

#### :white_check_mark: Recipe Controller
```java
http://localhost:8080/update/recipe
```
```java
http://localhost:8080/comment/recipe/{recipeId}
```
```java
http://localhost:8080/getAll/recipe/id/{id}
```
```java
http://localhost:8080/add/recipe
```
```java
http://localhost:8080/delete/recipe/id/{id}
```


## :six: Documentation in Swagger
```java
 http://localhost:8080/swagger-ui/index.html#/
```
![image](https://github.com/Avadheshshukla/E-commerce_App/assets/122303390/62b76bd9-10c8-4e0c-8ac0-b6ed3b62a9c7)
![image](https://github.com/Avadheshshukla/E-commerce_App/assets/122303390/f72f6d49-e045-45a1-b9a5-78ce2847cb2e)



## :seven: View in mySql Database

![image](https://github.com/Avadheshshukla/E-commerce_App/assets/122303390/b9c93f5b-1a2b-46d0-9bbd-581cadd90736)

![image](https://github.com/Avadheshshukla/E-commerce_App/assets/122303390/a5792292-97e1-4dfb-9ae9-d5814d09f9cb)



#  Summary
- :small_orange_diamond:  This is a sample recipe management system that allows two users :
- :one: Normal
- :two: Admin
- :small_orange_diamond: Admin users have all access to perform all the CRUD operations whereas the normal users can only edit and view the receipes.
-  :small_orange_diamond: The API is built using mySQL database to store the recipes,ingredients and all its fields . IP Address of the deployment link must be static to ensure its availability. Additionally , the Api's uses annotation based validations to ensure that all the user inputs are valid before being processed.
-  :small_orange_diamond: Therefore , this project provides a scalable and secure API that allows to manage all the datas.
